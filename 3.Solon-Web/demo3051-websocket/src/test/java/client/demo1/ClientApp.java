package client.demo1;

import org.noear.solon.Solon;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.SocketD;

import java.io.IOException;

/**
 * @author noear 2022/4/2 created
 */
public class ClientApp {
    public static void main(String[] args) {
        Solon.start(ClientApp.class, args, app -> {
            app.enableHttp(false);
        });

        Session session = SocketD.createSession("ws://localhost:8080/ws/demo/12");
        session.listener(new Listener() {
            @Override
            public void onMessage(Session session, Message message) throws IOException {
                System.out.println(message);
            }
        });

        session.send("test");
    }
}
