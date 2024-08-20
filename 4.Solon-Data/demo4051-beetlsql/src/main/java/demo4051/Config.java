package demo4051;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.DefaultNameConversion;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;


@Configuration
public class Config {
//有 “solon.dataSources” 配置后，不需要手动构建 bean
//    @Bean(name = "db1", typed = true)
//    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
//        return dataSource;
//    }

    @Bean
    public void db1m(@Db("db1") SQLManager sqlManager) {
        //sqlManager.setNc(new DefaultNameConversion());
        //sqlManager.setInters(new Interceptor[]{});
        //sqlManager.setDbStyle(new MySqlStyle());
    }
}
