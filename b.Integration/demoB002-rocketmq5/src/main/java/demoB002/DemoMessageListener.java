package demoB002;

import org.apache.rocketmq.client.apis.consumer.ConsumeResult;
import org.apache.rocketmq.client.apis.consumer.MessageListener;
import org.apache.rocketmq.client.apis.message.MessageView;
import org.noear.solon.annotation.Component;

/**
 * @author noear 2024/12/6 created
 */
@Component
public class DemoMessageListener implements MessageListener {

    @Override
    public ConsumeResult consume(MessageView messageView) {
        System.out.println(messageView);

        return ConsumeResult.SUCCESS;
    }
}
