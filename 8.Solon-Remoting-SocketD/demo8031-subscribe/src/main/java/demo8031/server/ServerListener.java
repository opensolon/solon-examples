package demo8031.server;

import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.solon.net.annotation.ServerEndpoint;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2023/11/13 created
 */
@ServerEndpoint
public class ServerListener extends SimpleListener {
    static final Map<String,Session> sessionMap = new HashMap<>();
    public static Collection<Session> getOpenSessions(){
        return sessionMap.values();
    }
    @Override
    public void onOpen(Session session) throws IOException {
        sessionMap.put(session.sessionId(), session);
    }

    @Override
    public void onClose(Session session) {
        sessionMap.remove(session.sessionId());
    }
}
