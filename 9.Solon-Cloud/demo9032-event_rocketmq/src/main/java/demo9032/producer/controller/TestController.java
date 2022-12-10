package demo9032.producer.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.stream.StreamSupport;

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

        Event event = new Event("hello.demo", msg);
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

        System.out.println(LocalDateTime.now());
        Event event = new Event("hello.demo", msg).scheduled(scheduled);
        return CloudClient.event().publish(event);
    }

    @Mapping("/test2")
    public Object test2(String msg) {
        if(Utils.isEmpty(msg)){
            msg = "demo2";
        }

        Event event = new Event("hello.demo2", msg).group("test");
        return CloudClient.event().publish(event);
    }
}
