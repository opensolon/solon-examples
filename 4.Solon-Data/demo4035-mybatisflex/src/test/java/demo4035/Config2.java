package demo4035;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.wood.DbContext;

@Configuration
public class Config2 {

    /**
     * 用于做单元测试清数据用
     * */
    @Bean
    public DbContext db1w(@Inject("db1") HikariDataSource dataSource) {
        String schema = dataSource.getSchema();
        return new DbContext(schema, dataSource);
    }
}
