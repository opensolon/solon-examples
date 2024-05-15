package demo9034.producer.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import org.noear.solon.cloud.model.EventTran;
import org.noear.solon.data.annotation.Tran;

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

        Event event = new Event("hello.demo", msg).qos(1).retained(true);
        return CloudClient.event().publish(event);
    }

    @Mapping("/test2")
    public Object test2(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "demo2";
        }

        Event event = new Event("hello.demo2", msg);
        return CloudClient.event().publish(event);
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
