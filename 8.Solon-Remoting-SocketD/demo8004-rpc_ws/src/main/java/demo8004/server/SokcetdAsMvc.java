package demo8004.server;

import org.noear.socketd.transport.server.ServerConfig;
import org.noear.socketd.transport.server.ServerConfigHandler;
import org.noear.solon.net.annotation.ServerEndpoint;
import org.noear.solon.net.socketd.handle.ToHandlerListener;

/**
 * @author noear 2023/11/12 created
 */
@ServerEndpoint
public class SokcetdAsMvc extends ToHandlerListener implements ServerConfigHandler {
    @Override
    public void serverConfig(ServerConfig config) {
        config.port(8080);
    }
}
