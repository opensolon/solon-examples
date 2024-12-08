package demoB001;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.Props;

import java.util.Properties;

/**
 * @author noear 2024/12/6 created
 */
@Configuration
public class KafkaConfig {
    @Bean
    public KafkaProducer<String, String> producer(@Inject("${solon.kafka.properties}") Props common,
                                                  @Inject("${solon.kafka.producer}") Props producer) {
        return new KafkaProducer<>(producer.addAll(common));
    }

    @Bean
    public KafkaConsumer<String, String> consumer(@Inject("${solon.kafka.properties}") Props common,
                                                  @Inject("${solon.kafka.consumer}") Props consumer) {

        return new KafkaConsumer<>(consumer.addAll(common));
    }
}
