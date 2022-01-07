package demo6013.controller;

import demo6013.controller.interceptor.TokenInterceptor;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;

/**
 * 一个简单的接口网关
 *
 * @author noear 2021/6/11 created
 */
@Mapping("/api/**")
@Component
public class ApiGateway extends ApiGatewayBase {
    @Override
    protected void register() {

        //添加个前置处理
        before(new TokenInterceptor());

        //添加Bean
        addBeans(bw -> "api".equals(bw.tag()));
    }
}
