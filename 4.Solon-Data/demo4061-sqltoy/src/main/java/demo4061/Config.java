package demo4061;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

/**
 * @author noear 2022/1/11 created
 */
@Configuration
public class Config {

    /**
     * 配置数据源
     */
    @Bean
    DataSource db1(@Inject("${datasource}") HikariDataSource ds){
        return ds;
    }

    //多数据源
    @Bean("db2")
    DataSource db2(@Inject("${datasource2}") HikariDataSource ds){
        return ds;
    }
}
