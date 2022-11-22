package demo3031;

import demo3031.dso.auth.AuthProcessorImpl;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.auth.AuthAdapter;

/**
 * @author noear 2021/6/1 created
 */
@Configuration
public class Config {
    @Bean
    public AuthAdapter init() {
        //
        // 构建适配器（规则配置）//如果鉴权出错，由 AuthFailureFilterImpl 处理
        //
        return new AuthAdapter()
                .loginUrl("/login") //设定登录地址，未登录时自动跳转
                .processor(new AuthProcessorImpl()) //设定认证处理器
                .addRule(r -> r.include("**").verifyIp().failure((c, t) -> c.output("你的IP不在白名单"))) //添加规则
                .addRule(b -> b.exclude("/login**").exclude("/run/**").verifyPath());//添加规则
    }
}
