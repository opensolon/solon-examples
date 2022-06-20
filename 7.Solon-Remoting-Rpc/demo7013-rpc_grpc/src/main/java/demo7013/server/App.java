package demo7013.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.grpc.annotation.EnableGrpc;

/**
 * @author noear 2022/6/20 created
 */
@EnableGrpc
public class App {
    public static void main(String[] args) throws Exception {
        Solon.start(App.class, args, app -> {
            app.enableHttp(false);
        }).block();
    }
}
