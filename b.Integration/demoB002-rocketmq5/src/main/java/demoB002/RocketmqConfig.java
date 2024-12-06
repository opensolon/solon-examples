package demoB002;

import org.apache.rocketmq.client.apis.*;
import org.apache.rocketmq.client.apis.consumer.FilterExpression;
import org.apache.rocketmq.client.apis.consumer.MessageListener;
import org.apache.rocketmq.client.apis.consumer.PushConsumer;
import org.apache.rocketmq.client.apis.consumer.PushConsumerBuilder;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.ProducerBuilder;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author noear 2024/12/6 created
 */
@Configuration
public class RocketmqConfig {
    private ClientServiceProvider clientProvider = ClientServiceProvider.loadService();

    @Bean
    public ClientConfiguration client(@Inject("${solon.rocketmq.properties}") Properties common){
        ClientConfigurationBuilder builder = ClientConfiguration.newBuilder();
        //注入属性
        Utils.injectProperties(builder, common);

        return builder.build();
    }

    @Bean
    public Producer producer(@Inject("${solon.rocketmq.producer}") Properties producer,
                             ClientConfiguration clientConfiguration) throws ClientException {
        ProducerBuilder producerBuilder = clientProvider.newProducerBuilder();

        //注入属性
        if (producer.size() > 0) {
            Utils.injectProperties(producerBuilder, producer);
        }

        producerBuilder.setClientConfiguration(clientConfiguration);

        return producerBuilder.build();
    }

    @Bean
    public PushConsumer consumer(@Inject("${solon.rocketmq.consumer}") Properties consumer,
                                 ClientConfiguration clientConfiguration,
                                 MessageListener messageListener) throws ClientException{

        //按需选择 PushConsumerBuilder 或 SimpleConsumerBuilder
        PushConsumerBuilder consumerBuilder = clientProvider.newPushConsumerBuilder();

        //注入属性
        Utils.injectProperties(consumerBuilder, consumer);

        Map<String, FilterExpression> subscriptionExpressions = new HashMap<>();
        subscriptionExpressions.put("topic.test",  new FilterExpression("*"));

        consumerBuilder.setSubscriptionExpressions(subscriptionExpressions);
        consumerBuilder.setClientConfiguration(clientConfiguration);
        consumerBuilder.setMessageListener(messageListener);

        return consumerBuilder.build();
    }
}