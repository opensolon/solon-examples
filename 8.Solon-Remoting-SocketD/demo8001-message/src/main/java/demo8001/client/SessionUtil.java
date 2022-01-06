package demo8001.client;

import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.SessionManager;

/**
 * @author noear 2021/1/9 created
 */
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
