package demo4061;

import com.zaxxer.hikari.HikariDataSource;
import demo4061.domain.Dictionary;
import demo4061.domain.User;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.Aop;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2022/1/10 created
 */
@Configuration
public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class,args);

        //初始化测试数据
        Aop.getAsyn(SqlToyLazyDao.class,bw->{
            SqlToyLazyDao dao=bw.get();
            Map params=new HashMap();
            dao.executeSql("CREATE TABLE `T_USER`(`USER_NAME` VARCHAR(40)  NOT NULL COMMENT '用户名',`GENDER` TINYINT   DEFAULT '0' COMMENT '性别',PRIMARY KEY (`USER_NAME`))",params);
            User u=new User();
            u.setGender(0);
            u.setUsername("test");
            dao.save(u);
            u=new User();
            u.setGender(1);
            u.setUsername("test1");
            dao.save(u);
            dao.executeSql("CREATE TABLE `T_DICT`(`SN` VARCHAR(10)  NOT NULL COMMENT '编码',`TITLE` VARCHAR(50)  COMMENT '值',PRIMARY KEY (`SN`))",params);
            Dictionary gender_0=new Dictionary();
            gender_0.setSn("0");
            gender_0.setTitle("男");
            Dictionary gender_1=new Dictionary();
            gender_1.setSn("1");
            gender_1.setTitle("女");
            dao.save(gender_0);
            dao.save(gender_1);
        });
    }
    /**
     * 配置数据源
     * @param dataSource
     * @return
     */
    @Bean
    DataSource db1(@Inject("${datasource}")HikariDataSource dataSource){
        return dataSource;
    }
}
