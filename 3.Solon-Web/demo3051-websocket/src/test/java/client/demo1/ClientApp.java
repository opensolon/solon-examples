package client.demo1;

import org.noear.java_websocket.client.SimpleWebSocketClient;

/**
 * @author noear 2022/4/2 created
 */
public class ClientApp {
    public static void main(String[] args) throws Exception{
        SimpleWebSocketClient client = new SimpleWebSocketClient("ws://localhost:8080/ws/demo/12") {
            @Override
            public void onMessage(String message) {
                System.out.println(message);
            }
        };

        client.connectBlocking();
        client.send("test");
    }
}
