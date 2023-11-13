package demo8011.server;


import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.solon.net.annotation.ServerEndpoint;


//定义服务端监听
@ServerEndpoint
public class ServerListener extends SimpleListener {
    @Override
    public void onOpen(Session session) {
        System.out.println("有客户端链上来喽...");
    }

    @Override
    public void onMessage(Session session, Message message) {
        //收到消息，做业务处理
        System.out.println("服务端：我收到：" + message.dataAsString());
    }
}
