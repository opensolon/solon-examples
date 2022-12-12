package demo9032_tag.producer.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author noear 2021/1/27 created
 */
@Controller
public class TestController {
    @Mapping("/test")
    public Object test(String msg) {
        if(Utils.isEmpty(msg)){
            msg = "demo";
        }

        Event event = new Event("hello2.demo", msg)
                .tags("test");
        return CloudClient.event().publish(event);
    }

    @Mapping("/test2")
    public Object test2(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "demo2";
        }

        long time = System.currentTimeMillis() + 10 * 1000;

        Event event = new Event("hello2.demo2", msg)
                .group("test")
                .tags("test")
                .scheduled(new Date(time));
        return CloudClient.event().publish(event);
    }
}
