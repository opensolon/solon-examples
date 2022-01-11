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
     * @param dataSource
     * @return
     */
    @Bean
    DataSource db1(@Inject("${datasource}") HikariDataSource dataSource){
        return dataSource;
    }
}
