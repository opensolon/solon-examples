package client;

import demo8041.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2022/4/24 created
 */
@Controller
public class DemoController {
    @NamiClient(url = "tcp://localhost:28080/demoe/rpc")
    HelloService helloService;

    @Mapping("hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
