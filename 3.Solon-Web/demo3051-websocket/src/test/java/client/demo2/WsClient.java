package client.demo2;

import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.annotation.ClientEndpoint;

import java.io.IOException;

/**
 * @author noear 2022/4/2 created
 */
@ClientEndpoint(uri="ws://localhost:8080/ws/demo/12")
public class WsClient implements Listener {
    @Override
    public void onOpen(Session session) {
        session.send("test");
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        System.out.println(message);
    }
}
