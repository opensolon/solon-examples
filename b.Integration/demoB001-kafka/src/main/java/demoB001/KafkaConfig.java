package demoB001;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import java.util.Properties;

/**
 * @author noear 2024/12/6 created
 */
@Configuration
public class KafkaConfig {
    @Bean
    public KafkaProducer<String, String> producer(@Inject("${solon.kafka.properties}") Properties common,
                                             @Inject("${solon.kafka.producer}") Properties producer) {

        Properties props = new Properties();
        props.putAll(common);
        props.putAll(producer);

        return new KafkaProducer<>(props);
    }

    @Bean
    public KafkaConsumer<String, String> consumer(@Inject("${solon.kafka.properties}") Properties common,
                                                  @Inject("${solon.kafka.consumer}") Properties consumer) {
        Properties props = new Properties();
        props.putAll(common);
        props.putAll(consumer);

        return new KafkaConsumer<>(props);
    }
}
