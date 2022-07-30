package demo3036;

import demo3036.dso.AuthProcessorImpl;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.auth.AuthUtil;

/**
 * @author noear 2021/6/12 created
 */
@Configuration
public class Config {
    @Bean
    public void authAdapter(){
        AuthUtil.adapter()
                .processor(new AuthProcessorImpl());
    }
}
