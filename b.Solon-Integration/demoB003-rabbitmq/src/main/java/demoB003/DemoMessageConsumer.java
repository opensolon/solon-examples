package demoB003;

import com.rabbitmq.client.*;
import org.noear.solon.annotation.Managed;

import java.io.IOException;

/**
 * @author noear 2024/12/6 created
 */
@Managed
public class DemoMessageConsumer extends DefaultConsumer implements Consumer {

    public DemoMessageConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println(body);

        getChannel().basicAck(envelope.getDeliveryTag(), false);
    }
}
