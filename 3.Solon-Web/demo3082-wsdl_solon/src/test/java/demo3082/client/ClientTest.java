package demo3082.client;

import org.noear.solon.Solon;

//启动 Solon
public class ClientTest {
    public static void main(String[] args) {
        Solon.start(ClientTest.class, args, app -> app.enableHttp(false));
    }
}