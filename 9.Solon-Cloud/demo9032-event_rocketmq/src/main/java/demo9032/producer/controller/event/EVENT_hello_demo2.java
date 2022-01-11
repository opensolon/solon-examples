package demo9032.producer.controller.event;

import org.noear.snack.ONode;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;

/**
 * @author noear 2021/1/27 created
 */
@CloudEvent(topic = "hello.demo2",group = "test")
public class EVENT_hello_demo2 implements CloudEventHandler {
    @Override
    public boolean handler(Event event) throws Throwable {
        System.out.println(LocalDateTime.now() + ONode.stringify(event));

        return event.times() > 2;
    }
}
