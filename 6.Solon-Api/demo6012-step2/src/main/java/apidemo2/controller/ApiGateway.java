package apidemo2.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Gateway;
import org.noear.solon.core.handle.Result;

/**
 * 一个简单的接口网关
 *
 * @author noear 2021/6/11 created
 */
@Mapping("/api/**")
@Component
public class ApiGateway extends Gateway {
    @Override
    protected void register() {

        //添加个拦截器
        before(c -> {
            //检测有没有token（用 param 替代；方便手浏览器测试）
            if (c.param("t") == null) {
                //如果没有令牌；直接设定结果
                c.result = Result.failure(403, "Missing authentication information");

                //设为已处理（主接口就不会进去了）
                c.setHandled(true);
            }
        });

        //添加Bean
        addBeans(bw -> "api".equals(bw.tag()));
    }

    //重写染处理异常
    @Override
    public void render(Object obj, Context c) throws Throwable {
        if (obj instanceof Throwable) {
            c.render(Result.failure("unknown error"));
            return;
        }

        super.render(obj, c);
    }
}
