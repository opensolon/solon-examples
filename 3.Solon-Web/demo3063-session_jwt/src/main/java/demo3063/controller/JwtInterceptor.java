package demo3063.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2021/8/6 created
 */
@Mapping(value = "**",before = true)
@Component
public class JwtInterceptor implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        //如果是登录页则不处理
        if("/login".equals(ctx.path())){
            return;
        }

        String user_name = ctx.session("user_name","");
        if(Utils.isEmpty(user_name)){
            //说明未登录，则终止处理
            ctx.setHandled(true);
        }
    }
}
