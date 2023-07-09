package demo4101;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.redisson.api.RedissonClient;
import org.redisson.solon.RedissonSupplier;

@Configuration
public class Config {
    @Bean
    public RedissonClient redis(@Inject("${test.redis1}")RedissonSupplier supplier){
        System.out.println("config - redis");
        return supplier.get();
    }
}
