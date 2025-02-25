package demoB002;

import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.java.message.MessageBuilderImpl;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2024/12/6 created
 */
@Controller
public class DemoController {
    @Inject
    private Producer producer;

    @Mapping("/send")
    public void send(String msg) throws ClientException {
        //发送
        producer.send(new MessageBuilderImpl()
                .setTopic("topic.test")
                .setBody(msg.getBytes())
                .build());
    }
}
