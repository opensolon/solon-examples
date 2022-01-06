package demo1001.demo1;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

/**
 * 注入到配置器的构建参数（与注入字段的方式差不多）
 *
 * @author noear 2021/12/28 created
 */
@Configuration
public class Config {
    @Bean
    public DataSource db1(@Inject("${track.db1}") HikariDataSource ds) {
        return ds;
    }
}

