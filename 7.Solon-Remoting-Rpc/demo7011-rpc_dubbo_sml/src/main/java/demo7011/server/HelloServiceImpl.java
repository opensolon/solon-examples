package demo7011.server;

import org.apache.dubbo.config.annotation.Service;
import demo7011.protocol.HelloService;

@Service(group = "demo")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
