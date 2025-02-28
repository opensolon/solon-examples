package demoC001.controller;

import org.noear.solon.ai.chat.ChatModel;
import org.noear.solon.annotation.*;
import org.noear.solon.core.util.MimeType;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Mapping("hello")
@Controller
public class HelloController {
    @Inject
    ChatModel chatModel;

    //简单返回
    @Mapping("case1")
    public String case1(@Param(defaultValue = "hello") String message) throws IOException {
        return chatModel.prompt(message).call().getMessage().getContent();
    }

    //流式返回
    @Produces(MimeType.TEXT_EVENT_STREAM_UTF8_VALUE) //这个很重要，申明用 sse 格式渲染
    @Mapping("case2")
    public Flux<String> case2(@Param(defaultValue = "hello") String message) throws IOException {
        return Flux.from(chatModel.prompt(message).stream())
                .filter(resp -> resp.hasChoices())
                .map(resp -> resp.getMessage().getContent());
    }
}