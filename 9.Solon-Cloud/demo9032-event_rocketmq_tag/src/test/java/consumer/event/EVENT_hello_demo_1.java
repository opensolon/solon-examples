package consumer.event;

import org.noear.snack.ONode;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;

/**
 * @author noear 2021/1/27 created
 */
@CloudEvent(topic = "hello2.demo", tag = "test")
public class EVENT_hello_demo_1 implements CloudEventHandler {
    @Override
    public boolean handle(Event event) throws Throwable {
        //
        //学示处理成功效果
        //
        System.out.println("bbb: " + LocalDateTime.now() + ONode.stringify(event));
        return true;
    }
}
