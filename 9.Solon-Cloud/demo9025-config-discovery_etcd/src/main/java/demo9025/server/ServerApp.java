package demo9025.server;

import org.noear.solon.Solon;
import org.noear.solon.cloud.CloudClient;

/**
 * @author luke
 */
public class ServerApp {
    public static void main(String[] args) {
        Solon.start(ServerApp.class, args);

        CloudClient.config().push(Solon.cfg().appGroup(),"test.properties","db1.url=jdbc111\n" +
                "db1.username=luke0125\n" +
                "db1.password=123456\n" +
                "db1.jdbcUrl=${db1.url}");
    }
}
