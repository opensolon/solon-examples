package demo9023.server;

import org.noear.solon.Solon;
import org.noear.solon.cloud.CloudClient;

/**
 * @author noear 2021/1/8 created
 */
public class ServarApp {
    public static void main(String[] args) {
        Solon.start(ServarApp.class, args);

        CloudClient.config().push(Solon.cfg().appGroup(),"test.properties","db1.url=jdbc\n" +
                "db1.username=noear\n" +
                "db1.password=xxx\n" +
                "db1.jdbcUrl=${db1.url}");
    }
}
