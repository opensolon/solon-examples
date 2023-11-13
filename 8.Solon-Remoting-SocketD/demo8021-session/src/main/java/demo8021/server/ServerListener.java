package demo8021.server;


import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.solon.net.annotation.ServerEndpoint;

import java.io.IOException;

//定义服务端监听
@ServerEndpoint
public class ServerListener extends SimpleListener {
    @Override
    public void onOpen(Session session) {
        System.out.println("有客户端链上来喽...");
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        //发送出一个Response包
        if(message.isRequest() || message.isSubscribe()){
            session.replyEnd(message, new StringEntity("你是谁?"));
        }
    }
}
