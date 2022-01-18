package demo3063.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;

/**
 * @author noear 2021/8/6 created
 */
@Controller
public class LoginController {
    /**
     * 登录
     * */
    @Mapping("/login")
    public void login(Context ctx, String name) {
        if ("noear".equals(name)) {
            //登录成功
            ctx.sessionSet("user_name", name);
        }
    }

    /**
     * 退出
     * */
    @Mapping("/logout")
    public void logout(Context ctx) {
        ctx.sessionClear();
    }


    /**
     * 登录2。如果想手动传，做为接口的一部分；把：server.session.jwt.allowAutoIssue 设为 false
     */
    @Mapping("/login2")
    public Result login2(Context ctx, String name) {
        if ("noear".equals(name)) {
            ctx.sessionSet("user_name", name);

            return Result.succeed(ctx.sessionState().sessionToken());
        } else {
            return Result.failure();
        }
    }
}
