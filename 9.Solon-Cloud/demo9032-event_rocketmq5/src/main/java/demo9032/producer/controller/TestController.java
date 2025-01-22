package demo9032.producer.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import org.noear.solon.cloud.model.EventTran;

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

        Event event = new Event("hello.demo", msg).metaPut("a","a");
        return CloudClient.event().publish(event);
    }

    @Mapping("/test2")
    public Object test2(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "demo2";
        }

        long time = System.currentTimeMillis() + 10 * 1000;

        Event event = new Event("hello.demo2", msg).group("test").metaPut("a","a").scheduled(new Date(time));
        return CloudClient.event().publish(event);
    }

    @Mapping("/test3")
    public Object test3(String msg) {
        if(Utils.isEmpty(msg)){
            msg = "demo";
        }

        Event event = new Event("hello.demo3", msg);
        return CloudClient.event().publish(event);
    }

    @Mapping("/tran")
    public Object tran() {
        EventTran eventTran = CloudClient.event().newTran();

        try {
            //只能一条消息
            CloudClient.event().publish(new Event("hello.demo", "test1").tran(eventTran));

            eventTran.commit();
            return true;
        } catch (Throwable e) {
            e.printStackTrace();

            eventTran.rollback();
            return false;
        }
    }

    @Mapping("/tran2")
    public Object tran2() {
        EventTran eventTran = CloudClient.event().newTran();

        try {
            //只能一条消息
            CloudClient.event().publish(new Event("hello.demo", "test1").tran(eventTran));
            throw new IllegalStateException("");
        } catch (Throwable e) {
            e.printStackTrace();

            eventTran.rollback();
            return true;
        }
    }
}
