package demo9034.producer.controller.event;

import org.noear.snack4.ONode;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.annotation.EventLevel;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;

/**
 * @author noear 2021/1/27 created
 */
@CloudEvent(topic = "hello.demo3", level = EventLevel.instance)
public class EVENT_hello_demo3 implements CloudEventHandler {
    @Override
    public boolean handle(Event event) throws Throwable {
        System.out.println(LocalDateTime.now() + ONode.serialize(event));
        return true;
    }
}
