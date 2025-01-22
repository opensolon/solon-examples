package demo9031.producer.controller;

import demo9031.producer.controller.event.HelloEntity;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import org.noear.solon.cloud.model.EventTran;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranUtils;

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
        if (Utils.isEmpty(msg)) {
            msg = "noear";
        }

        HelloEntity entity = new HelloEntity();
        entity.name = "noear";
        return entity.publish();
    }

    @Mapping("/tran")
    public Object tran() {
        EventTran eventTran = CloudClient.event().newTran();

        try {
            CloudClient.event().publish(new Event("hello.demo", "test1").tran(eventTran));
            CloudClient.event().publish(new Event("hello.demo", "test2").tran(eventTran));
            CloudClient.event().publish(new Event("hello.demo", "test3").tran(eventTran));

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
            CloudClient.event().publish(new Event("hello.demo", "test1").tran(eventTran));
            CloudClient.event().publish(new Event("hello.demo", "test2").tran(eventTran));
            CloudClient.event().publish(new Event("hello.demo", "test3").tran(eventTran));
            throw new IllegalStateException("");
        } catch (Throwable e) {
            e.printStackTrace();

            eventTran.rollback();
            return true;
        }
    }

    @Tran
    @Mapping("/tran3")
    public Object tran3() {
        EventTran eventTran = CloudClient.event().newTranAndJoin();

        CloudClient.event().publish(new Event("hello.demo", "test1").tran(eventTran));
        CloudClient.event().publish(new Event("hello.demo", "test2").tran(eventTran));
        CloudClient.event().publish(new Event("hello.demo", "test3").tran(eventTran));

        return true;
    }
}
