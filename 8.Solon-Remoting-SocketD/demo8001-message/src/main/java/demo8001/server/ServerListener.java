package demo8001.server;


import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.socketd.utils.RunUtils;
import org.noear.solon.net.annotation.ServerEndpoint;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint
public class ServerListener extends SimpleListener {
    public static Map<String,Session> sessionMap = new HashMap<>();

    public static Collection<Session> getOpenSessions() {
        return sessionMap.values();
    }

    public static void broadcast(String text) throws IOException{
        for(Session s1 : getOpenSessions()){
            s1.send("/demo", new StringEntity(text));
        }
    }

    @Override
    public void onOpen(Session session) {
        sessionMap.put(session.sessionId(), session);

        System.out.println("服务端：有人来了");

        RunUtils.asyncAndTry(()->{
            session.send("demo", new StringEntity("你好啊..."));
        });

        ServerApp.status.complete(true);
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        try {
            //打印太快，控制台会卡
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("服务端：我收到：" + message);

        if (message.isSubscribe() || message.isRequest()) {
            session.replyEnd(message, new StringEntity("我收到了"));
        }
    }

    @Override
    public void onClose(Session session) {
        sessionMap.remove(session.sessionId());
    }
}
