package demo1083;

import org.noear.solon.Solon;
import org.noear.solon.admin.client.annotation.EnableAdminClient;
import org.noear.solon.admin.server.annotation.EnableAdminServer;
import org.noear.solon.annotation.SolonMain;

/**
 * @author noear 2023/7/26 created
 */
@EnableAdminServer
@EnableAdminClient
@SolonMain
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}
