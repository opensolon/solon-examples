package demo7012.server;

import demo7012.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(group = "hello")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("from client ：" + name);
        return "hello, " + name;
    }

    @Override
    public String sayHello2(String name) {
        return "hello2, " + name;
    }

    @Override
    public String sayHello3(String name) {
        return "hello3, " + name;
    }
}
