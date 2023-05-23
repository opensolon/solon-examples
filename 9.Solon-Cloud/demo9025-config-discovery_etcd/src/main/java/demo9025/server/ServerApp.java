package demo9025.server;

import org.noear.solon.Solon;
import org.noear.solon.cloud.CloudClient;

/**
 * @author luke
 */
public class ServerApp {
    public static void main(String[] args) {
        Solon.start(ServerApp.class, args);

        CloudClient.config().push("test.properties", "db1.url=jdbc\n" +
                "db1.username=solon\n" +
                "db1.password=xxx\n" +
                "db1.jdbcUrl=${db1.url}");

        CloudClient.config().push("water_cache_header", "ddd");
    }
}
