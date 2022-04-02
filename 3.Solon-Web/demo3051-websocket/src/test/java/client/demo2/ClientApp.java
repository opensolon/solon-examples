package client.demo2;

import org.noear.solon.Solon;

/**
 * @author noear 2022/4/2 created
 */
public class ClientApp {
    public static void main(String[] args) {
        Solon.start(ClientApp.class, args, app -> {
            app.enableHttp(false);
        });
    }
}
