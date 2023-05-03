package demo4041;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.activerecord.annotation.Db;

import javax.sql.DataSource;

/**
 * @author noear 2021/5/24 created
 */
@Configuration
public class Config {
    @Bean(value = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }

    @Bean("db2")
    public DataSource db2(@Inject("${test.db2}") HikariDataSource dataSource) {
        return dataSource;
    }

    @Bean
    public void db1Init(@Db("db1") ActiveRecordPlugin arp){
        //启用开发或调试模式（可以打印sql）
        if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
            arp.setDevMode(true);
        }
    }

    @Bean
    public void db2Init(@Db("db2") ActiveRecordPlugin arp){
        //启用开发或调试模式（可以打印sql）
        if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
            arp.setDevMode(true);
        }
    }
}
