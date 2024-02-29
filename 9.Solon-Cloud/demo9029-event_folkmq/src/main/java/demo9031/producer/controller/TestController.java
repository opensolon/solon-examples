package demo9031.producer.controller;

import demo9031.producer.controller.event.HelloEntity;
import org.noear.folkmq.client.MqClient;
import org.noear.folkmq.client.MqMessage;
import org.noear.snack.ONode;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
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
