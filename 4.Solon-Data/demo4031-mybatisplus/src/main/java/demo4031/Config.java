package demo4031;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import demo4031.dso.mybatisplus_ext.MyLogicSqlInjector;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.sql.SqlUtils;

@Configuration
public class Config {
//有 “solon.dataSources” 配置后，不需要手动构建 bean
//    @Bean(value = "db1", typed = true)
//    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
//        return ds;
//    }

    @Bean
    public void db1_cfg(
            @Inject SqlUtils sqlUtils,
            @Db("db1") MybatisConfiguration cfg,
            @Db("db1") GlobalConfig globalConfig) throws Exception {

        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if (s1.trim().length() > 10) {
                sqlUtils.sql(s1).update();
            }
        }

        ////

        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));

        cfg.setCacheEnabled(false);
        cfg.addInterceptor(plusInterceptor);

        globalConfig.setSqlInjector(new MyLogicSqlInjector());
    }

//    @Bean
//    public MybatisSqlSessionFactoryBuilder factoryBuilderNew(){
//        return new MybatisSqlSessionFactoryBuilderImpl();
//    }
}
