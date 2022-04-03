package demo4031;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.solon.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.solon.plugins.inner.PaginationInnerInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.ext.solon.Db;
import org.apache.ibatis.plugin.Interceptor;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.mybatisplus.integration.MybatisAdapterPlus;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean(value = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }

    @Bean
    public Interceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return plusInterceptor;
    }

//    @Bean
//    public void db1_interceptor(@Db("db1") org.apache.ibatis.session.Configuration cfg) {
//        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
//        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//
//        cfg.addInterceptor(plusInterceptor);
//    }
//
//    @Bean
//    public void db1_globalConfig(@Db("db1") MybatisAdapterPlus adapterPlus){
//        adapterPlus.getGlobalConfig()
//                .getDbConfig()
//                .setLogicDeleteField("delete");
//    }
}
