package demoC001.config;

import org.noear.solon.ai.chat.ChatModel;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

@Configuration
public class ChatConfig {
    @Bean
    public ChatModel chatModel(@Inject("${solon.ai.chat.deepseek}") org.noear.solon.ai.chat.ChatConfig config) {
        return ChatModel.of(config).build();
    }
}
