package apidemo1.controller.apis;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;


/**
 * 接口开发，与控制器开发差不多的; 但进入网关的接口，要用 @Component 注解
 *
 * @author noear 2021/6/11 created
 */
@Component(tag = "api")
public class API_hello_world {
    @Mapping("hello")
    public Result exec(String name) {
        return Result.succeed("Hello " + name);
    }
}
