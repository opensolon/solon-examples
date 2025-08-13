package demo6013.controller.apis;

import demo6013.controller.ApiBase;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;


/**
 * 接口开发，与控制器开发差不多的; 但进入网关的接口，要用 @Managed 注解
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
public class API_error extends ApiBase {
    @Mapping("error")
    public void exec() {
        throw new RuntimeException("随便报一下");
    }
}
