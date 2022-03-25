package demo4021;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.ext.solon.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.mybatis.MybatisAdapter;

import javax.sql.DataSource;

@Configuration
public class Config {
    //
    // 加上 typed = true 的作用：可以直接使用 @Db （不带name）
    //
    @Bean(name = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }

    @Bean
    public void db1Adapter(@Db("db1") MybatisAdapter adapter) {
        if(adapter == null){
            return;
        }
    }
}
