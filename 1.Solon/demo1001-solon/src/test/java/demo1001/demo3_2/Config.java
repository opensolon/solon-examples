package demo1001.demo3_2;

import demo1001.demo3_2.dso.service.UserService;
import demo1001.demo3_2.dso.service.impl.UserServiceImpl;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

/**
 * 用配置器类。本质是 @Configuration + @Bean 的组合，并且 Config 要被扫描到
 *
 * @author noear 2021/12/28 created
 */
@Configuration
public class Config{
    static String TITLE;

    @Bean
    public UserService build(){
        return new UserServiceImpl();
    }

    //顺带一提：也可空返回，做一些初始化动作
    @Bean
    public void initTitle(@Inject("${ser.title}") String title){
        Config.TITLE = title;
    }
}
