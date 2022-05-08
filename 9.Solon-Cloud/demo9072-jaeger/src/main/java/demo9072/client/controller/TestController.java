package demo9072.client.controller;

import demo9072.client.dso.service.OrderService;
import demo9072.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/6/7 created
 */
@Controller
public class TestController {
    @NamiClient
    HelloService helloService;

    @Inject
    OrderService orderCreate;

    @Mapping("/")
    public String hello(String name) {
        if(name == null){
            name = "world";
        }

        helloService.hello(name);

        orderCreate.orderCreate("11111");

        return "Rpc: " + helloService.hello2(name);
    }
}
