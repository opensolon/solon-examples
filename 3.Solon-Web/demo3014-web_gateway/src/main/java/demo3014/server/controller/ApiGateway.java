package demo3014.server.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Gateway;
import demo3014.server.dso.service.UserServiceImpl;

/**
 * 对第三方提供服务
 *
 * @author noear 2021/4/22 created
 */
@Mapping("/api/rest/**")
@Component
public class ApiGateway extends Gateway {
    @Override
    protected void register() {
        //或者由此
        before(c -> c.attrSet("@render", "@json"));

        //添加服务
        add("user", UserServiceImpl.class, true);

    }

//   也可以修改宣染
//
//    @Override
//    public void render(Object obj, Context c) throws Throwable {
//        c.outputAsJson(ONode.stringify(obj));
//    }
}
