package demo1011.plugin1;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cache.jedis.RedisCacheService;
import org.noear.solon.data.cache.CacheService;
import org.noear.solon.data.cache.impl.JsonSerializer;
import org.noear.wood.WoodConfig;

import javax.sql.DataSource;

/**
 * @author noear 2022/5/17 created
 */
@Configuration
public class Config {
    @Bean
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }

    @Bean
    public void initWood() {
        //执行后打印下sql
        WoodConfig.onExecuteAft(cmd -> {
            System.out.println(cmd.text + "\r\n" + ONode.stringify(cmd.paramMap()));
        });
    }

    @Bean
    public CacheService ch1(@Inject("${test.ch1}") RedisCacheService cacheService) {
        cacheService.serializer(JsonSerializer.instance);
        return cacheService;
    }
}
