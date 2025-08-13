package demo6011.controller.apis;

import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;


/**
 * 默认接口（没有对应接口时，就会到这里来）; 但进入网关的接口，要用 @Managed 注解
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
public class API_0 {
    //没有印射值，即为默认接口
    @Mapping
    public Result exec() {
        return Result.failure(404, "Interface does not exist");
    }
}
