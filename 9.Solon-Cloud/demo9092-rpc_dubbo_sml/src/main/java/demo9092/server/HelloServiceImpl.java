package demo9092.server;

import org.apache.dubbo.config.annotation.Service;
import demo9092.protocol.HelloService;

@Service(group = "hello")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
