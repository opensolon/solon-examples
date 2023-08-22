package consumer.event;

import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;

/**
 * @author noear 2023/8/16 created
 */
@Slf4j
@CloudEvent("msg/+/add")
public class EVENT_msg_demo implements CloudEventHandler {
    @Override
    public boolean handle(Event event) throws Throwable {
        log.info(LocalDateTime.now() + ONode.stringify(event));
        return true;
    }
}
