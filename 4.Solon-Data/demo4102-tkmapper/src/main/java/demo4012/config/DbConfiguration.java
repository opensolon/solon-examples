package demo4012.config;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @title: DbConfiguration
 * @author: trifolium.wang
 * @date: 2024/4/3
 */
@Configuration
public class DbConfiguration {

    @Bean(name = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        try {
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE user (" +
                    "  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "  `name` varchar(255) DEFAULT NULL," +
                    "  `age` int DEFAULT NULL," +
                    "  `create_time` datetime DEFAULT NULL," +
                    "  `is_del` tinyint(1) DEFAULT NULL" +
                    ")");

            statement.execute("INSERT INTO `user` (`id`, `name`, `age`, `create_time`, `is_del`) VALUES (1, '张三', 11, '2024-04-02 13:38:56', 0);\n" +
                    "INSERT INTO `user` (`id`, `name`, `age`, `create_time`, `is_del`) VALUES (2, '李四', 3, '2024-04-02 13:39:08', 0);\n" +
                    "INSERT INTO `user` (`id`, `name`, `age`, `create_time`, `is_del`) VALUES (3, '张麻子', 43, '2024-04-02 13:39:20', 0);");
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Datasource initialization Failure!");
        }
        return ds;
    }
}
