package demo4061;

import com.zaxxer.hikari.HikariDataSource;
import demo4061.model.Dictionary;
import demo4061.model.User;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.sagacity.sqltoy.solon.annotation.Db;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2022/1/11 created
 */
@Configuration
public class Config {

    /**
     * 配置数据源
     */
    @Bean
    public DataSource db1(@Inject("${datasource}") HikariDataSource ds) {
        return ds;
    }

    //多数据源
    @Bean("db2")
    public DataSource db2(@Inject("${datasource2}") HikariDataSource ds) {
        return ds;
    }

    @Bean
    public void dbInit(@Db SqlToyLazyDao dao, @Db("db2") SqlToyLazyDao dao2) {
        //初始化数据
        initData(dao, "default");
        //多数据源的初始化
        initData(dao2, "db2");
    }

    void initData(SqlToyLazyDao dao, String flag) {
        Map params = new HashMap();
        //init for T_USER
        dao.executeSql("CREATE TABLE `T_USER`(`USER_NAME` VARCHAR(40)  NOT NULL COMMENT '用户名',`GENDER` TINYINT   DEFAULT '0' COMMENT '性别',PRIMARY KEY (`USER_NAME`))", params);

        User u = new User();
        u.setGender(0);
        u.setUsername("test");
        dao.save(u);

        u = new User();
        u.setGender(1);
        u.setUsername("test1");
        dao.save(u);

        //init for T_DICT
        dao.executeSql("CREATE TABLE `T_DICT`(`SN` VARCHAR(10)  NOT NULL COMMENT '编码',`TITLE` VARCHAR(50)  COMMENT '值',PRIMARY KEY (`SN`))", params);
        Dictionary gender_0 = new Dictionary();
        gender_0.setSn("0");
        gender_0.setTitle("男");

        Dictionary gender_1 = new Dictionary();
        gender_1.setSn("1");
        gender_1.setTitle("女");

        dao.save(gender_0);
        dao.save(gender_1);
    }
}
