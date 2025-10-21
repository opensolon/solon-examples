package demo3073.controller;

import demo3073.manage.SseDemoManager;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;
import org.noear.solon.web.sse.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SSE (Server-Sent Events) 演示 Controller
 *
 * @Controller 表明这是一个控制器类。
 * @Mapping("/api/sse_demo") 为该控制器下的所有接口添加了路径前缀。
 */
@Slf4j
@Controller
@Mapping("/api/sse_demo")
public class SseDemoController {

    // 注入我们刚刚创建的 Manager
    @Inject
    private SseDemoManager sseDemoManager;

    /**
     * 创建一个单线程的线程池来执行我们的后台模拟任务。
     * 使用线程池可以避免阻塞处理HTTP请求的Web服务器线程，这是处理长任务的标准做法。
     * 定义为 static final 保证了整个应用只有一个实例。
     */
    private static final ExecutorService taskExecutor = Executors.newSingleThreadExecutor();

    /**
     * 接口 1: 触发后台任务 (GET /api/sse_demo/start)
     * <p>
     * 这个接口的作用是启动一个后台任务，并返回一个唯一的 taskId 给前端。
     * 它是整个SSE流程的起点。
     *
     * @return 返回一个包含 taskId 的 JSON 对象，例如: {"code": 200, "data": {"taskId": "xxxx-xxxx-xxxx"}}
     */
    @Get
    @Mapping("/start")
    public Result startTask() {
        // 1. 生成一个唯一的任务ID，用于标识本次任务和对应的SSE连接。
        String taskId = UUID.randomUUID().toString();
        log.info("接收到新的SSE任务请求，已生成ID: [{}]", taskId);

        // 2. 将模拟任务提交到线程池异步执行。
        //    把 taskId 传递给任务，以便任务知道要向哪个连接推送消息。
        taskExecutor.submit(() -> runSimulatedTask(taskId));

        // 3. 立即返回成功响应和 taskId 给客户端。
        //    客户端拿到这个 ID 后，就可以去请求 /connect/{taskId} 接口了。
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("taskId", taskId);
        return Result.succeed(dataMap);
    }

    /**
     * 接口 2: 建立 SSE 连接 (GET /api/sse_demo/connect/{taskId})
     * <p>
     * 这个接口是真正的 SSE 端点。浏览器会与它建立一个长连接，等待服务器推送消息。
     *
     * @param taskId 路径参数，由 /start 接口返回。
     * @return 返回一个 SseEmitter 实例，Solon 框架会自动处理后续的 SSE 协议。
     */
    @Get
    @Mapping("/connect/{taskId}")
    public SseEmitter connect(String taskId) {
        //注意，sse是没办法通过head传递参数的，如果是jwt，此处就得把令牌传过来自己进行验证鉴权。

        // 1. 创建 SseEmitter 实例。参数是超时时间（毫秒），-1L 或 0L 表示永不超时。
        final SseEmitter emitter = new SseEmitter(-1L);

        // 2. 将这个新的 emitter 添加到 Manager 中，与 taskId 关联起来。
        sseDemoManager.add(taskId, emitter);

        // 3. 设置连接完成时的回调函数 (非常重要！用于清理资源)。
        //    这个回调会在连接关闭时（客户端关闭、服务器调用 complete() 或超时）被触发。
        emitter.onCompletion(() -> {
            log.info("SSE 连接 onCompletion 回调触发, ID: [{}]", taskId);
            sseDemoManager.remove(taskId);
        });

        // 4. 设置连接发生错误时的回调函数 (同样重要！)。
        emitter.onError(e -> {
            log.error("SSE 连接 onError 回调触发, ID: [{}], 错误: ", taskId, e);
            sseDemoManager.remove(taskId);
        });

        // 5. (可选) 连接建立后，可以立即发送一条欢迎消息。
        sseDemoManager.sendEvent(taskId, "connected", "连接成功，等待任务进度的消息...");

        return emitter;
    }

    /**
     * 模拟一个后台长耗时任务。
     * 这个方法会在独立的线程中执行。
     *
     * @param taskId 任务的唯一标识符。
     */
    private void runSimulatedTask(String taskId) {
        try {
            // 模拟一个10步的任务，每步耗时1秒。
            for (int i = 1; i <= 10; i++) {
                // 模拟耗时操作
                Thread.sleep(1000);

                // 通过 manager 向指定的客户端推送 "progress" 事件
                // 数据可以是简单的字符串，也可以是复杂的JSON对象
                String progressMessage = String.format("任务正在执行... 第 %d/10 步完成。", i);
                Map<String, Object> progressData = new HashMap<>();
                progressData.put("step", i);
                progressData.put("total", 10);
                progressData.put("message", progressMessage);

                sseDemoManager.sendEvent(taskId, "progress", progressData);
                log.info("已向任务 [{}] 推送进度: {}/10", taskId, i);
            }

            // 任务成功完成，发送 "done" 事件
            sseDemoManager.sendEvent(taskId, "done", "恭喜！所有任务已成功完成！");

        } catch (InterruptedException e) {
            log.warn("模拟任务被中断, ID: [{}]", taskId, e);
            // 任务异常，发送 "error" 事件
            sseDemoManager.sendEvent(taskId, "task_error", "任务执行被意外中断。");
            Thread.currentThread().interrupt(); // 重新设置中断状态
        } catch (Exception e) {
            log.error("模拟任务执行出错, ID: [{}]", taskId, e);
            // 其他未知异常
            sseDemoManager.sendEvent(taskId, "task_error", "任务执行时发生未知错误: " + e.getMessage());
        } finally {
            // 无论任务成功、失败还是中断，最后都必须调用 complete() 来关闭 SSE 连接。
            // 这会告诉客户端数据流结束了。
            sseDemoManager.complete(taskId);
        }
    }
}

