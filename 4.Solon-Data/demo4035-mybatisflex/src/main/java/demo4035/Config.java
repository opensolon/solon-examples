package demo4035;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.sql.SqlUtils;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public void db1_cfg(@Inject SqlUtils sqlUtils) throws Exception {

        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if (s1.trim().length() > 10) {
                sqlUtils.sql(s1).update();
            }
        }
    }

    @Bean
    public void db2_cfg(@Inject("db2") SqlUtils sqlUtils) throws Exception {

        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if (s1.trim().length() > 10) {
                sqlUtils.sql(s1).update();
            }
        }
    }

    //有 solon.dataSources 配置后，不需要手动构建了
    //
    // 加上 typed = true 的作用：可以直接使用 @Db （不带name）
    //
//    @Bean(name = "db1", typed = true)
//    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
//        return ds;
//    }
//
//    //调整 db1 的配置，或添加插件
//    @Bean
//    public void db1_cfg(@Db("db1") org.apache.ibatis.session.Configuration cfg) {
//        cfg.setCacheEnabled(false);
//    }

//    @Bean
//    public MybatisSqlSessionFactoryBuilder factoryBuilderNew(){
//        return new MybatisSqlSessionFactoryBuilderImpl();
//    }
}
