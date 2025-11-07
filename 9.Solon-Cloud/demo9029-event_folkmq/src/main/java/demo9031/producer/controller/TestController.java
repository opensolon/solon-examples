package demo9031.producer.controller;

import demo9031.producer.controller.event.HelloEntity;
import org.noear.folkmq.client.MqClient;
import org.noear.folkmq.client.MqMessage;
import org.noear.snack4.ONode;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import org.noear.solon.cloud.model.EventTran;

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
        if(Utils.isEmpty(msg)){
            msg = "demo";
        }

        Event event = new Event("hello.demo3", msg).metaPut("a","a");
        return CloudClient.event().publish(event);
    }


    @Mapping("/test4")
    public Object test4(String msg) {
        if (Utils.isEmpty(msg)) {
            msg = "noear";
        }

        HelloEntity entity = new HelloEntity();
        entity.name = msg;
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

    @Inject
    MqClient mqClient;

    @Mapping("/rpc")
    public Object rpc(String name) throws Exception {
        if (Utils.isEmpty(name)) {
            name = "noear";
        }

        ONode oNode = new ONode();
        oNode.set("name", name);

        try {
            return mqClient.send(new MqMessage(oNode.toJson()).tag("/rpc/hello").asJson(), "helloconsumer", 10_000)
                    .await()
                    .dataAsString();
        } catch (Throwable e) {
            return e.getMessage();
        }
    }
}
