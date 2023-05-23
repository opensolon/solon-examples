package demo9021.server;

import org.noear.solon.Solon;
import org.noear.solon.cloud.CloudClient;

/**
 * @author noear 2021/1/8 created
 */
public class ServarApp {
    public static void main(String[] args) {
        Solon.start(ServarApp.class, args);

        CloudClient.config().push("test.properties", "db1.url=jdbc111\n" +
                "db1.username=solon\n" +
                "db1.password=xxx\n" +
                "db1.jdbcUrl=${db1.url}");

        CloudClient.config().push("water_cache_header", "ddd");
    }
}
