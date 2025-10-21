package demo3073.manage;

import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Destroy;
import org.noear.solon.web.sse.SseEmitter;
import org.noear.solon.web.sse.SseEvent;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SSE 连接管理器 (演示版)
 *
 * @Component 注解表示这是一个由 Solon 容器管理的单例组件。
 * 我们可以在其他组件中（如 Controller）通过 @Inject 注入它。
 */
@Slf4j
@Component
public class SseDemoManager {

    /**
     * 使用 ConcurrentHashMap 来存储 SSE 连接。
     * 1. Key: String - 每个 SSE 连接的唯一标识符 (我们称之为 taskId)。
     * 2. Value: SseEmitter - Solon 提供的 SSE 连接实例。
     * <p>
     * ConcurrentHashMap 是线程安全的，非常适合在多线程环境中（如 Web 服务器）管理共享资源。
     */
    private static final Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 添加一个新的 SSE 连接。
     *
     * @param taskId  连接的唯一标识符。
     * @param emitter SSE 连接实例。
     */
    public void add(String taskId, SseEmitter emitter) {
        sseEmitterMap.put(taskId, emitter);
        log.info("SSE 连接已创建，ID: [{}], 当前总连接数: {}", taskId, sseEmitterMap.size());
    }

    /**
     * 移除一个 SSE 连接。
     * 通常在连接关闭、出错或超时后调用。
     *
     * @param taskId 连接的唯一标识符。
     */
    public void remove(String taskId) {
        if (sseEmitterMap.containsKey(taskId)) {
            sseEmitterMap.remove(taskId);
            log.info("SSE 连接已移除，ID: [{}], 剩余连接数: {}", taskId, sseEmitterMap.size());
        }
    }

    /**
     * 向指定ID的连接发送一个 "命名事件"。
     * 命名事件在前端可以通过 addEventListener('eventName', ...) 来监听，非常灵活。
     *
     * @param taskId    连接的唯一标识符。
     * @param eventName 事件名称。
     * @param data      要发送的数据 (可以是字符串、JSON对象等)。
     */
    public void sendEvent(String taskId, String eventName, Object data) {
        SseEmitter emitter = sseEmitterMap.get(taskId);
        if (emitter == null) {
            log.warn("尝试向已关闭或不存在的 SSE 连接发送事件，ID: [{}]", taskId);
            return;
        }

        try {
            String jsonData = ONode.stringify(data);

            // 1. 创建 SseEvent 对象
            SseEvent event = new SseEvent()
                    .name(eventName) // 2. 设置事件名称
                    .data(jsonData);    // 可选：将数据序列化为 JSON 格式

            // 4. 发送事件
            emitter.send(event);
        } catch (IOException e) {
            log.error("发送 SSE 事件时出错, ID: [{}], 错误: {}", taskId, e.getMessage());
            // 发送失败通常意味着连接已断开，直接移除
            this.remove(taskId);
        }
    }

    /**
     * 当任务完成时，主动关闭 SSE 连接。
     * 这会触发前端的 oncomplete 事件。
     *
     * @param taskId 连接的唯一标识符。
     */
    public void complete(String taskId) {
        SseEmitter emitter = sseEmitterMap.get(taskId);
        if (emitter != null) {
            emitter.complete();
            // complete() 会最终触发 onCompletion 回调， সেখানে连接会被移除，所以这里不需要再调用 remove。
            log.info("SSE 连接已由服务器主动完成, ID: [{}]", taskId);
        }
    }


    /**
     * Solon 的生命周期注解。
     * 当应用关闭时，这个方法会被调用，用于优雅地关闭所有资源。
     */
    @Destroy
    public void cleanup() {
        log.info("应用关闭，正在清理所有 SSE 连接...");
        sseEmitterMap.forEach((id, emitter) -> {
            emitter.complete(); // 通知所有客户端连接已关闭
        });
        sseEmitterMap.clear();
        log.info("所有 SSE 连接已清理完毕。");
    }
}
