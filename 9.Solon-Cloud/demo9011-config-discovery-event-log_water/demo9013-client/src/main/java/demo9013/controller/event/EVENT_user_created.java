package demo9013.controller.event;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;

/**
 * @author noear 2021/3/12 created
 */
@Slf4j
@CloudEvent("user.created")
public class EVENT_user_created implements CloudEventHandler {

    @Override
    public boolean handler(Event event) throws Throwable {
        //日志会自动进入 solon cloud log service
        //
        log.info("有个用户建了...");

        return true;
    }
}
