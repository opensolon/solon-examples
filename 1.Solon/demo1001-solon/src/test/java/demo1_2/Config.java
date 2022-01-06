package demo1_2;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 构建Bean给配置器用
 *
 * @author noear 2021/12/28 created
 */
@Configuration
public class Config {
    @Bean
    public DataSource db1() {
        return Solon.cfg().getBean("track.db1", HikariDataSource.class);
    }
}