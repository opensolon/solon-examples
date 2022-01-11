package demo9071.client.controller;

import demo9071.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/6/7 created
 */
@Controller
public class TestController {
    @NamiClient
    HelloService helloService;

    @Mapping("/")
    public String hello(String name) {
        helloService.hello(name);

        return "Rpc: " + helloService.hello(name);
    }
}
