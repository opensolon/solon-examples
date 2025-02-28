package demoC001.controller;

import org.noear.solon.ai.chat.ChatModel;
import org.noear.solon.ai.chat.message.ChatMessage;
import org.noear.solon.ai.rag.Document;
import org.noear.solon.ai.rag.Repository;
import org.noear.solon.ai.rag.util.QueryCondition;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;

import java.io.IOException;
import java.util.List;

@Mapping("rag")
@Controller
public class RagController {
    @Inject
    ChatModel chatModel;

    @Inject
    Repository repository;

    @Inject("localRepository")
    Repository localRepository;

    //联网搜索
    @Mapping("websearch")
    public String websearch(@Param(defaultValue = "solon 是谁开发的？") String message) throws IOException {
        //检索
        List<Document> context = repository.search(new QueryCondition(message).limit(4));

        //消息增强
        ChatMessage chatMessage = ChatMessage.augment(message, context);

        //提交大模型并简单返回（不然，截图不好截）
        return chatModel.prompt(chatMessage).call().getMessage().getContent();
    }

    //本地知识库
    @Mapping("local")
    public String local(@Param(defaultValue = "solon 是谁开发的？") String message) throws IOException {
        //检索
        List<Document> context = localRepository.search(new QueryCondition(message).limit(4));

        //消息增强
        ChatMessage chatMessage = ChatMessage.augment(message, context);

        //提交大模型并简单返回（不然，截图不好截）
        return chatModel.prompt(chatMessage).call().getMessage().getContent();
    }
}
