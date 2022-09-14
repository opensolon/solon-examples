package demo4051;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;


@Configuration
public class Config {
    //@Bean(attrs = {"dialect=oracle"}) //通过特性，指定BeetlSQL的方言
    @Bean(name = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }

    @Db
    SQLManager sqlManager;


    @Init
    public void init(){
        //sqlManager.addIdAutoGen();
    }
}


//@Configuration
//public class Config {
//
//    //
//    //  申明 db2 是 db1 为的从库
//    //
//    @Bean(name = "smsMaster", attrs = {"slaves=smsSlave", "dialect=sqlserver"})
//    public DataSource db1(@Inject("${sms.master}") HikariDataSource dataSource) {
//        return dataSource;
//    }
//
//    @Bean("smsSlave")
//    public DataSource db2(@Inject("${sms.slave}") HikariDataSource dataSource) {
//        return dataSource;
//    }
//}


