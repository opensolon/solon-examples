package demo1082;

import org.noear.solon.Solon;
import org.noear.solon.admin.client.config.EnableAdminClient;
import org.noear.solon.annotation.SolonMain;

/**
 * @author noear 2023/7/26 created
 */
@EnableAdminClient
@SolonMain
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}
