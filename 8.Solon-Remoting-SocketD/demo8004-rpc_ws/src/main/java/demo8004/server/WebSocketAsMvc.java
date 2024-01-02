package demo8004.server;

import org.noear.socketd.transport.core.internal.ConfigImpl;
import org.noear.solon.net.annotation.ServerEndpoint;
import org.noear.solon.net.socketd.handle.ToHandlerListener;
import org.noear.solon.net.websocket.socketd.ToSocketdWebSocketListener;

/**
 * @author noear 2023/11/12 created
 */
@ServerEndpoint
public class WebSocketAsMvc extends ToSocketdWebSocketListener {

    public WebSocketAsMvc() {
        super(new ConfigImpl(false), new ToHandlerListener());
    }
}
