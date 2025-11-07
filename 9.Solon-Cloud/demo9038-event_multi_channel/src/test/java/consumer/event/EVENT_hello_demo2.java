package consumer.event;

import org.noear.snack4.ONode;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;

/**
 * @author noear 2021/1/27 created
 */
@CloudEvent(value = "hello.demo2", channel = "biz")
public class EVENT_hello_demo2 implements CloudEventHandler {
    @Override
    public boolean handle(Event event) throws Throwable {
        //
        //演示守护效果
        //
        System.out.println(LocalDateTime.now() + ONode.serialize(event));
        return event.times() > 2;
    }
}