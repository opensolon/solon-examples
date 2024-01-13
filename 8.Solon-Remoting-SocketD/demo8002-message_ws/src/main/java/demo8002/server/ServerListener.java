package demo8002.server;


import org.noear.socketd.transport.core.*;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.impl.ConfigDefault;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.socketd.utils.RunUtils;
import org.noear.solon.net.annotation.ServerEndpoint;
import org.noear.solon.net.websocket.socketd.ToSocketdWebSocketListener;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 将 WebSocket 协议，转为 SocketD  协议
 * */
@ServerEndpoint
public class ServerListener extends ToSocketdWebSocketListener {
    public static Map<String, Session> sessionMap = new HashMap<>();

    public ServerListener() {
        super(new ConfigDefault(false), new SimpleListenerImpl());
    }

    public static Collection<Session> getOpenSessions() {
        return sessionMap.values();
    }

    public static class SimpleListenerImpl extends SimpleListener {
        @Override
        public void onOpen(Session session) {
            sessionMap.put(session.sessionId(), session);

            System.out.println("服务端：有人来了");

            RunUtils.asyncAndTry(() -> {
                session.send("demo", new StringEntity("你好啊..."));
            });

            ServerApp.status.complete(true);
        }

        @Override
        public void onMessage(Session session, Message message) {
            System.out.println("服务端：我收到：" + message + message.dataAsString());
        }

        @Override
        public void onClose(Session session) {
            sessionMap.remove(session.sessionId());
        }

        @Override
        public void onError(Session session, Throwable error) {

        }
    }
}
