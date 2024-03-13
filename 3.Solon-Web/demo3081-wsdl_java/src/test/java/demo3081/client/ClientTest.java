package demo3081.client;

public class ClientTest {
    public static void main(String[] args) {
        WsInterface ws = new WsInterfaceImplService().getWsInterfacePort();
        String name = ws.sayInputName("demo");
        System.out.println(name);
    }
}