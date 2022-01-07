package apidemo1.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Gateway;

/**
 * 一个简单的接口网关
 *
 * @author noear 2021/6/11 created
 */
@Mapping("/api/**")
@Component
public class ApiGateway extends Gateway {
    @Override
    protected void register() {
        //添加Bean
        addBeans(bw -> "api".equals(bw.tag()));
    }
}
