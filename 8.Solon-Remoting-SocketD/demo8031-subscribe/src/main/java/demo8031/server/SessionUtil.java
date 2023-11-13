package demo8031.server;


import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;

//定义一个给所有会话广播的工具
public class SessionUtil {
    public static void broadcast(Message message) throws Exception {
        for (Session session : ServerListener.getOpenSessions()) {
            session.send(message.topic(), message.entity());
        }
    }

    public static void broadcast(String message) throws Exception {
        for (Session session : ServerListener.getOpenSessions()) {
            session.send("demo", new StringEntity(message));
        }
    }
}
