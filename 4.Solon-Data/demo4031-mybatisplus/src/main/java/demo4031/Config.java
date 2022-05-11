package demo4031;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.solon.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.solon.plugins.inner.PaginationInnerInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean(value = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }

    @Bean
    public void db1_interceptor(@Db("db1") org.apache.ibatis.session.Configuration cfg) {
        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        cfg.setCacheEnabled(false);
        cfg.addInterceptor(plusInterceptor);
    }

//    @Bean
//    public void db1_globalConfig(@Db("db1") GlobalConfig globalConfig) {
//        //此参数会自动生成实现baseMapper的基础方法映射
//        globalConfig.setSqlInjector(new DefaultSqlInjector());
//        //设置id生成器
//        globalConfig.setIdentifierGenerator(new DefaultIdentifierGenerator());
//        //设置超类mapper
//        globalConfig.setSuperMapperClass(BaseMapper.class);
//    }
}
