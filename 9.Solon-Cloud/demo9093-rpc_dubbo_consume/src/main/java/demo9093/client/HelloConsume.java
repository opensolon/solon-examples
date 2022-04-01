package demo9093.client;

import demo9093.service.HelloService;
import demo9093.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

@Controller
public class HelloConsume {
    @Reference(group = "hello")
    HelloService helloService;

    @Reference
    UserService userService;

    @Mapping("/")
    public String home(){
        return helloService.sayHello(userService.getUser("noear"));
    }
}
