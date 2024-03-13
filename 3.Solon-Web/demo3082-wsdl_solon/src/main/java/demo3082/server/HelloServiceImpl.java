package demo3082.server;

import javax.jws.WebService;

@WebService(serviceName = "HelloService", targetNamespace = "http://demo.solon.io")
public class HelloServiceImpl {
    public String hello(String name) {
        return "hello " + name;
    }
}
