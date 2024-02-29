package consumer;

import org.noear.folkmq.client.MqConsumeListener;
import org.noear.folkmq.solon.MqSolonListener;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MqConsumeListener mqRpcAsMvc(){
        return new MqSolonListener();
    }
}
