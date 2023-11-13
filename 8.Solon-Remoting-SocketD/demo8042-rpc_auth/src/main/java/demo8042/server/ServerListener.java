package demo8042.server;

import org.noear.socketd.transport.core.Session;
import org.noear.solon.net.annotation.ServerEndpoint;
import org.noear.solon.net.socketd.handle.ToHandlerListener;

import java.io.IOException;

/**
 * @author noear 2023/11/13 created
 */
@ServerEndpoint
public class ServerListener extends ToHandlerListener {
    @Override
    public void onOpen(Session session) throws IOException {
        if ("1".equals(session.param("token"))) {
            System.out.println("签权成功!");
        } else {
            session.close();
        }
    }
}
