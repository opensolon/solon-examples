package demo4082.config;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author noear 2022/1/11 created
 */
@Configuration
public class Config {


    /**
     * 配置数据源
     */
    @Bean(name = "db1", typed = true)
    public DataSource db1(@Inject("${datasource.db1}") HikariDataSource ds) {
        return ds;
    }


//    @Bean
//    public void dbInit(@Inject DataSource ds) throws Exception {
//        DbContext db = new DbContext(ds);
//
//        db.exe("CREATE TABLE `USER`(`USER_NAME` VARCHAR(40)  NOT NULL COMMENT '用户名',`GENDER` TINYINT   DEFAULT '0' COMMENT '性别',PRIMARY KEY (`USER_NAME`))");
//    }
}
