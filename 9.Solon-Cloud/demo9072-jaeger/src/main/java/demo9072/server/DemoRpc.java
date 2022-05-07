package demo9072.server;

import org.noear.solon.Solon;

/**
 * @author noear 2021/6/10 created
 */
public class DemoRpc {
    public static void main(String[] args) {
        Solon.start(DemoRpc.class, args, app -> {
            app.enableHttp(false);
            app.enableSocketD(true);
        });
    }
}
