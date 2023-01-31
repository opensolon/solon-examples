package demo3062.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;
import org.noear.solon.core.route.RouterInterceptor;
import org.noear.solon.core.route.RouterInterceptorChain;

/**
 * @author noear 2021/8/6 created
 */
@Component
public class JwtInterceptor implements RouterInterceptor {

    @Override
    public void doIntercept(Context ctx, Handler mainHandler, RouterInterceptorChain chain) throws Throwable {
        //如果是登录页则不处理
        if("/login".equals(ctx.path()) == false) {
            String user_name = ctx.session("user_name", "");
            if (Utils.isEmpty(user_name)) {
                //说明未登录，则终止处理
                ctx.status(401);
                return;
            }
        }

        chain.doIntercept(ctx, mainHandler);
    }
}
