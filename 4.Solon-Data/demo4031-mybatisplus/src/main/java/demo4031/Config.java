package demo4031;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.solon.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.solon.plugins.inner.PaginationInnerInterceptor;
import demo4031.dso.mybatisplus_ext.MyLogicSqlInjector;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;

@Configuration
public class Config {
//有 “solon.dataSources” 配置后，不需要手动构建 bean
//    @Bean(value = "db1", typed = true)
//    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
//        return ds;
//    }

    @Bean
    public void db1_cfg(@Db("db1") MybatisConfiguration cfg,
                        @Db("db1") GlobalConfig globalConfig) {
        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        cfg.setCacheEnabled(false);
        cfg.addInterceptor(plusInterceptor);

        globalConfig.setSqlInjector(new MyLogicSqlInjector());
    }

//    @Bean
//    public MybatisSqlSessionFactoryBuilder factoryBuilderNew(){
//        return new MybatisSqlSessionFactoryBuilderImpl();
//    }
}
