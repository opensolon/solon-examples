package demo4041;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

/**
 * @author noear 2021/5/24 created
 */
@Configuration
public class Config {
    @Bean
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }

    @Bean("db2")
    public DataSource db2(@Inject("${test.db2}") HikariDataSource dataSource) {
        return dataSource;
    }
}
