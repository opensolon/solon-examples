package apidemo4.controller.apis;

import apidemo4.controller.ApiBase;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

/**
 * @author noear 2021/6/17 created
 */
@Component(tag = "api")
public class API_test_login extends ApiBase {
    @Mapping("test.login")
    public String exec(Context ctx) {
        //登录成功后....（代码略）

        //设置session
        ctx.sessionSet("user_id", 12L);

        //将session值，手动生成token并做为接口的结果输出
        return ctx.sessionState().sessionToken();


        //如果：server.session.state.jwt.allowIssue=true，则会自动输出
    }
}
