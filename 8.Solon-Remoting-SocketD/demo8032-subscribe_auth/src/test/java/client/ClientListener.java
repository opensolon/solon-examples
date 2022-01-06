package client;

import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.annotation.ClientEndpoint;

@ClientEndpoint(uri = "tcp://localhost:28080", handshakeHeader = "sn=1&token=1", heartbeatRate = 1)
public class ClientListener implements Listener {
    @Override
    public void onMessage(Session session, Message message) {
        //收到消息，业务处理
        System.out.println("客户端：我收到了：" + message.bodyAsString());
    }
}
