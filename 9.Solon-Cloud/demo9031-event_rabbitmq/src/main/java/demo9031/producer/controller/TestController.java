package demo9031.producer.controller;

import demo9031.producer.controller.event.HelloEntity;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;

import java.util.Date;

/**
 * @author noear 2021/1/27 created
 */
@Controller
public class TestController {
    @Mapping("/test")
    public Object test(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "demo2";
        }

        Event event = new Event("hello.demo", msg);
        return CloudClient.event().publish(event);
    }

    @Mapping("/test2")
    public Object test2(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "demo2";
        }

        long time = System.currentTimeMillis() + 10 * 1000;

        Event event = new Event("hello.demo2", msg).group("test").scheduled(new Date(time));
        return CloudClient.event().publish(event);
    }


    @Mapping("/test3")
    public Object test3(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "noear";
        }

        HelloEntity entity = new HelloEntity();
        entity.name = "noear";
        return entity.publish();
    }
}
