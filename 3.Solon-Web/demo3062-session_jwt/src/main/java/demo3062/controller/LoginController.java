package demo3062.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

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
}
