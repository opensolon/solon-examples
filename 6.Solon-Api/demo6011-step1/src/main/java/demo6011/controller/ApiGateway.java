package demo6011.controller;

import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Gateway;

/**
 * 一个简单的接口网关
 *
 * @author noear 2021/6/11 created
 */
@Mapping("/api/**")
@Managed
public class ApiGateway extends Gateway {
    @Override
    protected void register() {
        //添加Bean
        addBeans(bw -> "api".equals(bw.tag()));
    }
}
