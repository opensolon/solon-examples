package demo9074.server;

import org.noear.solon.Solon;
import org.noear.solon.net.annotation.ServerEndpoint;
import org.noear.solon.net.socketd.handle.ToHandlerListener;

/**
 * @author noear 2021/6/10 created
 */
@ServerEndpoint
public class DemoRpc extends ToHandlerListener {
    public static void main(String[] args) {
        Solon.start(DemoRpc.class, args, app -> {
            app.enableHttp(false);
            app.enableSocketD(true);
        });
    }
}
