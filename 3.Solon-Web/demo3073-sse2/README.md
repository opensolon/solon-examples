# Solon SSE 实时任务演示

这是一个使用 [Solon Framework](https://solon.noear.org/) 构建的 Server-Sent Events (SSE) 完整示例项目。它演示了如何为一个后台长耗时任务（如文件导出、批量处理等）提供实时的进度反馈给前端页面。


## 核心功能

*   **实时进度更新**：通过 SSE 将后台任务的进度实时推送到浏览器，并更新进度条和日志。
*   **清晰的职责分离**：通过 `Controller` 和 `Manager` 类分离了 Web 接入层和 SSE 连接管理的逻辑。
*   **动态任务ID**：为每个任务请求生成唯一的ID，确保多用户同时使用时互不干扰。
*   **命名事件 (Named Events)**：使用自定义事件名（如 `progress`, `done`, `task_error`）来推送不同类型的消息，使前端逻辑更清晰。
*   **健壮的连接管理**：实现了完整的连接生命周期管理，包括创建、错误处理和资源清理。

## 技术栈

*   **后端**: Solon Framework (`solon-web`, `solon-web-sse`)
*   **前端**: 原生 HTML, CSS, JavaScript (`EventSource` API)
*   **视图模板**: FreeMarker (`solon-view-freemarker`)
*   **构建工具**: Maven

---

## 从零开始构建 SSE 应用（教程）

本教程将指导你如何一步步构建这个项目。

### 核心思路：两阶段通信

不同于 WebSocket 的双向通信，SSE 是服务器到客户端的单向推送。为了实现对特定任务的推送，我们采用一种经典的两阶段模式：

1.  **阶段一：启动任务**
    *   客户端（浏览器）向一个普通的 REST API（例如 `/api/sse_demo/start`）发起请求。
    *   服务器立即在后台线程中启动一个长耗时任务，并生成一个唯一的 `taskId`。
    *   服务器**立即**将这个 `taskId` 返回给客户端，HTTP 请求结束。

2.  **阶段二：建立 SSE 连接**
    *   客户端拿到 `taskId` 后，向一个专门的 SSE 端点（例如 `/api/sse_demo/connect/{taskId}`）发起连接请求。
    *   服务器接收到连接后，将其与 `taskId` 关联并保持这个长连接。
    *   后台任务在执行过程中，通过 `taskId` 找到对应的连接，并将进度消息通过这个连接推送给客户端。
    *   任务完成后，服务器主动关闭连接。

### 步骤 1: 项目初始化与依赖配置

首先，创建一个标准的 Solon Maven 项目。在 `pom.xml` 文件中，我们需要添加以下核心依赖：

```xml
<dependencies>
    <!-- Solon Web 核心 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon-web</artifactId>
    </dependency>

    <!-- SSE 支持 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon-web-sse</artifactId>
    </dependency>

    <!-- 模板引擎，用于渲染HTML页面 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon-view-freemarker</artifactId>
    </dependency>

    <!-- 日志实现 -->
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon-logging-logback</artifactId>
    </dependency>
</dependencies>
```

### 步骤 2: 创建 SSE 连接管理器 (`SseDemoManager.java`)

这个类是整个 SSE 功能的核心，它负责存储和管理所有活跃的 SSE 连接。

**职责**:
*   提供一个线程安全的容器（如 `ConcurrentHashMap`）来存储 `taskId` 和 `SseEmitter` 的映射。
*   提供添加、移除、发送消息和完成连接的公共方法。
*   **关键点**: 在发送对象数据时，确保将其序列化为 **JSON 字符串**，因为前端需要解析 JSON。

```java
// src/main/java/com/example/demo/manage/SseDemoManager.java
package com.example.demo.manage;

import lombok.extern.slf4j.Slf4j;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.web.sse.SseEmitter;
import org.noear.solon.web.sse.SseEvent;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class SseDemoManager {

    private static final Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    // 添加连接
    public void add(String taskId, SseEmitter emitter) {
        sseEmitterMap.put(taskId, emitter);
        log.info("SSE 连接已创建, ID: [{}], 当前总连接数: {}", taskId, sseEmitterMap.size());
    }

    // 移除连接
    public void remove(String taskId) {
        if (sseEmitterMap.containsKey(taskId)) {
            sseEmitterMap.remove(taskId);
            log.info("SSE 连接已移除, ID: [{}], 剩余连接数: {}", taskId, sseEmitterMap.size());
        }
    }

    // 发送命名事件
    public void sendEvent(String taskId, String eventName, Object data) {
        SseEmitter emitter = sseEmitterMap.get(taskId);
        if (emitter == null) {
            return;
        }

        try {
            // 将任意对象序列化为JSON字符串
            String jsonData = ONode.serialize(data);

            SseEvent event = new SseEvent()
                    .name(eventName)
                    .data(jsonData); // 发送JSON字符串

            emitter.send(event);
        } catch (IOException e) {
            log.error("发送 SSE 事件时出错, ID: [{}]", taskId, e.getMessage());
            this.remove(taskId);
        }
    }

    // 主动完成（关闭）连接
    public void complete(String taskId) {
        SseEmitter emitter = sseEmitterMap.get(taskId);
        if (emitter != null) {
            emitter.complete();
        }
    }
}
```

### 步骤 3: 创建控制器 (`SseDemoController.java`)

控制器负责处理 HTTP 请求，并串联起整个业务流程。

**职责**:
*   提供 `/start` 接口用于启动任务并返回 `taskId`。任务必须在**新线程**中执行，以避免阻塞HTTP请求。
*   提供 `/connect/{taskId}` 接口用于建立 SSE 连接。
*   在 `/connect` 接口中，创建 `SseEmitter` 实例，并为其设置 `onCompletion` (完成时) 和 `onError` (出错时) 的回调，这对于清理 `SseDemoManager` 中的资源至关重要。

```java
// src/main/java/com/example/demo/controller/SseDemoController.java
package com.example.demo.controller;

import com.example.demo.manage.SseDemoManager;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Result;
import org.noear.solon.web.sse.SseEmitter;
import java.util.*;
import java.util.concurrent.*;

@Slf4j
@Controller
@Mapping("/api/sse_demo")
public class SseDemoController {

    @Inject
    private SseDemoManager sseDemoManager;

    // 使用线程池异步执行任务
    private static final ExecutorService taskExecutor = Executors.newSingleThreadExecutor();

    @Get
    @Mapping("/start")
    public Result startTask() {
        String taskId = UUID.randomUUID().toString();
        taskExecutor.submit(() -> runSimulatedTask(taskId));
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("taskId", taskId);
        return Result.succeed(dataMap);
    }
  
    @Get
    @Mapping("/connect/{taskId}")
    public SseEmitter connect(String taskId) {
        // 创建一个永不超时的 SseEmitter
        final SseEmitter emitter = new SseEmitter(-1L);
      
        // 存入 Manager
        sseDemoManager.add(taskId, emitter);
      
        // 设置完成回调，用于清理资源
        emitter.onCompletion(() -> sseDemoManager.remove(taskId));
      
        // 设置错误回调，用于清理资源
        emitter.onError(e -> sseDemoManager.remove(taskId));

        // 发送一个连接成功的消息
        sseDemoManager.sendEvent(taskId, "connected", "连接成功，等待任务进度的消息...");

        return emitter;
    }

    // 模拟后台任务
    private void runSimulatedTask(String taskId) {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000);
                Map<String, Object> progressData = new HashMap<>();
                progressData.put("step", i);
                progressData.put("total", 10);
                progressData.put("message", String.format("任务正在执行... 第 %d/10 步完成。", i));
              
                // 通过 Manager 推送进度事件
                sseDemoManager.sendEvent(taskId, "progress", progressData);
            }
            sseDemoManager.sendEvent(taskId, "done", "恭喜！所有任务已成功完成！");
        } catch (Exception e) {
            sseDemoManager.sendEvent(taskId, "task_error", "任务执行时发生未知错误: " + e.getMessage());
        } finally {
            // 任务结束，无论成功失败，都调用 complete 关闭连接
            sseDemoManager.complete(taskId);
        }
    }
}
```

### 步骤 4: 创建前端页面 (`index.ftl`)

前端使用浏览器原生的 `EventSource` API 来与后端进行 SSE 通信。

**职责**:
*   提供一个按钮来触发 `/start` 请求。
*   获取到 `taskId` 后，创建 `new EventSource("/api/sse_demo/connect/" + taskId)`。
*   使用 `addEventListener` 监听后端发送的各种**命名事件**（`connected`, `progress`, `done` 等）。
*   **关键点**: 在接收到 `progress` 事件的数据后，使用 `JSON.parse()` 将其从字符串转换回 JavaScript 对象，以便使用。
*   处理 `onopen` 和 `onerror` 等标准连接事件。

```html
<!-- src/main/resources/templates/index.ftl -->
<!DOCTYPE html>
<html>
<head>
    <title>Solon SSE 实时任务演示</title>
    <!-- ... CSS ... -->
</head>
<body>
    <!-- ... HTML for button, progress bar, log area ... -->

<script>
    const startButton = document.getElementById('startButton');
    // ... other element getters ...

    let eventSource = null;

    startButton.addEventListener('click', async () => {
        // ... UI reset logic ...

        try {
            // 1. 请求 /start 获取 taskId
            const response = await fetch('/api/sse_demo/start');
            const result = await response.json();
            const taskId = result.data.taskId;

            // 2. 使用 taskId 创建 EventSource 连接
            eventSource = new EventSource('/api/sse_demo/connect/' + taskId);
          
            // 3. 监听各种事件
            eventSource.onopen = function () {
                logMessage('SSE 连接已成功建立！', 'success');
            };

            eventSource.onerror = function (err) {
                logMessage('SSE 连接发生错误，将自动关闭。', 'error');
                eventSource.close();
                resetUI();
            };

            // 监听自定义的 'progress' 事件
            eventSource.addEventListener('progress', function (event) {
                // 将 JSON 字符串解析为对象
                const progressData = JSON.parse(event.data);
                const percentage = ((progressData.step / progressData.total) * 100).toFixed(0);

                // 更新UI
                progressBar.style.width = percentage + '%';
                progressBar.textContent = percentage + '%';
                logMessage('收到 [progress] 事件: ' + progressData.message, 'event');
            });

            // 监听 'done' 事件
            eventSource.addEventListener('done', function (event) {
                logMessage('收到 [done] 事件: ' + event.data, 'success');
                // 服务器会主动关闭连接，这里仅重置UI
                setTimeout(resetUI, 1000);
            });
          
            // 监听 'task_error' 事件
             eventSource.addEventListener('task_error', function (event) {
                logMessage('收到 [task_error] 事件: ' + event.data, 'error');
                eventSource.close();
                resetUI();
            });

        } catch (error) {
            logMessage('操作失败: ' + error.message, 'error');
            resetUI();
        }
    });
</script>
</body>
</html>
```

### 步骤 5: 运行和测试

1.  **启动应用**：在项目根目录下运行命令 `mvn solon:run`。
2.  **访问页面**：打开浏览器，访问 `http://localhost:8080`。
3.  **开始任务**：点击“开始任务”按钮，观察进度条和日志的变化。

你现在已经成功构建了一个功能完善的 SSE 实时进度通知应用！