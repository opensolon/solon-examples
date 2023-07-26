package demo1081;

import org.noear.solon.Solon;
import org.noear.solon.admin.server.config.EnableAdminServer;
import org.noear.solon.annotation.SolonMain;

/**
 * @author noear 2023/7/26 created
 */
@EnableAdminServer
@SolonMain
public class AdminApp {
    public static void main(String[] args) {
        Solon.start(AdminApp.class, args);
    }
}
