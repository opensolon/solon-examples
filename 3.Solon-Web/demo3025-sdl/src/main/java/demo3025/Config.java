package demo3025;

import org.noear.redisx.RedisClient;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.validation.annotation.LoginedChecker;
import org.noear.solon.web.sso.SsoLoginedChecker;
import org.noear.solon.web.sso.SsoStorage;
import org.noear.solon.web.sso.impl.SsoStorageOfRedis;

/**
 * 主要是为了构建： SsoService 和 SsoLoginedChecker
 *
 * @author noear 2023/4/5 created
 */
@Configuration
public class Config {
    @Bean
    public SsoStorage ssoService(@Inject("${demo.redis}") RedisClient redisClient) {
        // RedisClient 可以通过配置自己构建
        // 如果使用的是别的Redis框架，可以自己实现SsoService（只有两个接口）
        return new SsoStorageOfRedis(redisClient);
    }

    @Bean
    public LoginedChecker ssoLoginedChecker() {
        return new SsoLoginedChecker();
    }
}
