package demo3031b.user;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.auth.AuthAdapter;

/**
 * @author noear 2022/8/15 created
 */
@Configuration
public class UserAuthAdapter {
    @Bean
    public AuthAdapter initAuthAdapter() {
        return new AuthAdapter()
                .pathPrefix("/user/")
                .loginUrl("/user/login") //设定登录地址，未登录时自动跳转
                .addRule(b -> b.include("/user/**").exclude("/user/login**").verifyPath()) //添加规则
                .processor(new UserAuthProcessorImpl()) //设定认证处理器
                .failure((ctx, rst) -> { //设定默认的验证失败处理
                    ctx.render(rst);
                });
    }
}