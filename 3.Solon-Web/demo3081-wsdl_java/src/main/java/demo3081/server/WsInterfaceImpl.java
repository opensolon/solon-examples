package demo3081.server;

import javax.jws.WebService;

@WebService(name = "WsInterface", serviceName = "WsInterface", targetNamespace = "http://impl.xcc.com/")
public class WsInterfaceImpl {
    public String sayInputName(String name) {
        return "input: " + name;
    }
}