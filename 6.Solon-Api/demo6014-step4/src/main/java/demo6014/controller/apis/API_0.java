package demo6014.controller.apis;

import demo6014.controller.ApiBase;
import demo6014.controller.ApiCodes;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;


/**
 * 默认接口（没有对应接口时，就会到这里来）; 但进入网关的接口，要用 @Managed 注解
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
public class API_0 extends ApiBase {
    //没有印射值，即为默认接口
    @Mapping
    public void exec() {
       throw ApiCodes.CODE_4001011;
    }
}
