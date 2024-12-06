package demoB001;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.noear.solon.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.util.Arrays;

/**
 * @author noear 2024/12/6 created
 */
@Component
public class DemoJob {
    @Inject
    private KafkaConsumer<String, String> consumer;

    @Init
    public void init() {
        //订阅
        consumer.subscribe(Arrays.asList("topic.test"));
    }

    @Scheduled(fixedDelay = 10_000L, initialDelay = 10_000L)
    public void job() throws Exception {
        //拉取
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(record.value());
            //确认
            consumer.commitSync();
        }
    }
}
