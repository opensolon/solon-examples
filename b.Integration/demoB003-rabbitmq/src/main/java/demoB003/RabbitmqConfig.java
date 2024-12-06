package demoB003;

import com.rabbitmq.client.*;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.Props;

import java.util.Map;
import java.util.Properties;

/**
 * @author noear 2024/12/6 created
 */
@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE_NAME = "demo-exchange";

    @Bean
    public Channel client(@Inject("${solon.rabbitmq.properties}") Properties common) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 注入属性
        Utils.injectProperties(connectionFactory, common);

        // 创建连接与通道
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        // 配置交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        return channel;
    }

    @Bean
    public void producer(@Inject("${solon.rabbitmq.producer}") Props producer,
                         Channel channel) throws Exception {

        //申明需要发布确认（以提高可靠性）
        channel.confirmSelect();
        long waitForConfirms = producer.getLong("waitForConfirms", 0L);
    }

    @Bean
    public void consumer(@Inject("${solon.rabbitmq.consumer}") Props consumer,
                         Channel channel,
                         Consumer messageConsumer) throws Exception {

        // for basicQos
        int prefetchCount = consumer.getInt("basicQos.prefetchCount", 10);
        int prefetchSize = consumer.getInt("basicQos.prefetchSize", 0);
        boolean global = consumer.getBool("basicQos.global", false);
        channel.basicQos(prefetchSize, prefetchCount, global);

        // for queueDeclare
        String queue = consumer.get("queueDeclare.queue");
        boolean durable = consumer.getBool("queueDeclare.durable", true);
        boolean exclusive = consumer.getBool("queueDeclare.exclusive", false);
        boolean autoDelete = consumer.getBool("queueDeclare.autoDelete", false);
        Map arguments = consumer.getMap("queueDeclare.arguments");

        channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
        channel.queueBind(queue, EXCHANGE_NAME, queue);

        //for basicConsume
        channel.basicConsume(queue, false, messageConsumer);
    }
}
