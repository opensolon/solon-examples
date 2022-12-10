package demo9035.producer.controller;

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
            msg = "demo2";
        }

        Event event = new Event("hello.demo", msg).qos(1).retained(true);
        return CloudClient.event().publish(event);
    }

    @Mapping("/test1")
    public Object test1(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "demo";
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.plusSeconds(3);
        Date scheduled = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        Event event = new Event("hello.demo", msg).scheduled(scheduled);
        return CloudClient.event().publish(event);
    }

    @Mapping("/test2")
    public Object test2(String msg) {
        if(Utils.isEmpty(msg)){
            msg = "demo2";
        }

        Event event = new Event("hello.demo2", msg);
        return CloudClient.event().publish(event);
    }
}
