package demo6012.controller.apis;

import demo6012.controller.ApiBase;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;


/**
 * 接口开发，与控制器开发差不多的; 但进入网关的接口，要用 @Managed 注解
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
public class API_hello_world extends ApiBase {
    @Mapping("hello")
    public Result exec(String name) {
        return Result.succeed("Hello " + name);
    }
}
