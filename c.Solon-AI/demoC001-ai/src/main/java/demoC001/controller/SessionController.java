package demoC001.controller;

import org.noear.solon.ai.chat.ChatModel;
import org.noear.solon.ai.chat.ChatSession;
import org.noear.solon.ai.chat.ChatSessionDefault;
import org.noear.solon.ai.chat.message.ChatMessage;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author noear 2025/2/25 created
 */
@Mapping("session")
@Controller
public class SessionController {
    private static Map<String, ChatSession> chatSessionMap = new ConcurrentHashMap<>();

    @Inject
    private ChatModel chatModel;

    @Mapping("chat")
    public String chat(Context ctx, String message) throws IOException {
        ChatSession session = chatSessionMap.computeIfAbsent(ctx.sessionId(), k -> new ChatSessionDefault(k));

        session.addMessage(ChatMessage.ofUser(message));

        ChatMessage message2 = chatModel.prompt(session).call().getMessage();

        session.addMessage(message2);

        return message2.getContent();
    }
}
