package demo4001;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.cache.CacheService;
import org.noear.solon.data.cache.CacheServiceSupplier;

/**
 * @author noear 2022/3/25 created
 */
@Configuration
public class Demo1Config {
    @Bean
    public CacheService cahce1(@Inject("${demo1.cache}") CacheServiceSupplier supplier) {
        return supplier.get();
    }
}
