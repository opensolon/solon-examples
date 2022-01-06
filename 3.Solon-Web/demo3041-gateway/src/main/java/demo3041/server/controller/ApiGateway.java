package demo3041.server.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Gateway;
import demo3041.server.controller.api.UserServiceImpl;
import org.noear.solon.core.handle.Result;

/**
 * 对第三方或者客户端提供服务
 *
 * @author noear 2021/4/22 created
 */
@Mapping("/api/v1/**")
@Component
public class ApiGateway extends Gateway {
    @Override
    protected void register() {
        //添加服务
        add("user", UserServiceImpl.class);
    }


    @Override
    public void render(Object obj, Context ctx) throws Throwable {
        //
        // 格式化为：{code:200,description:"",data:{}} 风格
        //
        if (obj instanceof Throwable) {
            ctx.render(Result.failure(((Throwable) obj).getLocalizedMessage()));
        } else {
            ctx.render(Result.succeed(obj));
        }
    }
}
