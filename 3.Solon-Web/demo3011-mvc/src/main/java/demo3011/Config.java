package demo3011;

import demo3011.dso.LocalCacheService;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.data.cache.CacheService;
import org.noear.solon.validation.ValidatorManager;
import org.noear.solon.validation.annotation.Date;
import org.noear.solon.validation.annotation.DateValidator;


@Configuration
public class Config {
    @Bean
    public void validAdapter() {
        //
        // 添加Date验证器
        //
        ValidatorManager.register(Date.class, DateValidator.instance);
        //
        // 适配验证输出，更友好些
        //
        ValidatorManager.setFailureHandler((ctx, ano, rst, message) -> {
            ctx.setHandled(true);

            if (Utils.isEmpty(message)) {
                message = new StringBuilder(100)
                        .append("@")
                        .append(ano.annotationType().getSimpleName())
                        .append(" verification failed(")
                        .append(rst.getDescription()).append(")")
                        .toString();
            }

            ctx.output(message);

            return true;
        });
    }

    /**
     *
     */
//    @Bean
//    public CacheService cache() {
//        return new NotCacheService();
//    }

    /**
     * 定义一个缓存服务
     * */
    @Bean
    public CacheService cache1() {
        return new LocalCacheService();
    }
}
