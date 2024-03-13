package demo3081.server;


import javax.xml.ws.Endpoint;

public class ServerTest {
    public static void main(String[] args) {
        WsInterfaceImpl ws = new WsInterfaceImpl();

        Endpoint.publish("http://localhost:8888/service-ws/demo",ws);

        System.out.println("server 启动成功: http://localhost:8888/service-ws/demo?wsdl");
    }
}