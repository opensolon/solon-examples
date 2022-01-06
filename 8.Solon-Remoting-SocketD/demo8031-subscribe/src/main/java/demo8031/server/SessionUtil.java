package demo8031.server;

import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.SessionManager;

//定义一个给所有会话广播的工具
public class SessionUtil {
    public static void broadcast(Message message){
        for(Session session : SessionManager.socket().getOpenSessions()){
            session.send(message);
        }
    }

    public static void broadcast(String message){
        for(Session session : SessionManager.socket().getOpenSessions()){
            session.send(message);
        }
    }
}
