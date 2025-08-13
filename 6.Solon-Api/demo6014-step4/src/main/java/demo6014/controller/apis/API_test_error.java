package demo6014.controller.apis;

import demo6014.controller.ApiBase;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.validation.annotation.Logined;


/**
 * 接口开发，与控制器开发差不多的; 但进入网关的接口，要用 @Managed 注解
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
public class API_test_error extends ApiBase {
    @Logined //登录用户才可用
    @Mapping("test.error")
    public void exec() {
        throw new RuntimeException("随便报一下");
    }
}
