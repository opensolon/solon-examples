package demo4013;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

import javax.sql.DataSource;


@Configuration
public class Config {
//有 “solon.dataSources” 配置后，不需要手动构建 bean
//    @Bean
//    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) throws Exception{
//        return ds;
//    }

//    @Bean
//    public void db2Init(@Db DbContext db) throws Exception{
//        db.exe("insert into user(id) values(1),(2)");
//    }
}

