package demo4001;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.cache.CacheService;
import org.noear.solon.data.cache.CacheServiceSupplier;
import org.noear.solon.data.cache.LocalCacheService;
import org.noear.solon.data.cache.SecondCacheService;

/**
 * @author noear 2022/3/25 created
 */
@Configuration
public class Demo2Config {
    @Bean
    public CacheService cahce1(@Inject("${demo1.cache}") CacheServiceSupplier supplier) {
        CacheService cacheService = supplier.get();

        if (cacheService instanceof LocalCacheService) {
            //如果是本地缓存，直接返回
            return cacheService;
        } else {
            //尝试构建二级缓存，且缓冲5秒（1级为本地；2级为配置的）
            LocalCacheService local = new LocalCacheService();
            SecondCacheService tmp = new SecondCacheService(local, cacheService, 5);

            return tmp;
        }
    }
}
