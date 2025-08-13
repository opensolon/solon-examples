package demo6014.controller;

import demo6014.controller.interceptor.TokenHandler;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.net.http.HttpUtils;


/**
 * 一个简单的接口网关（分布式网关）
 *
 * @author noear 2022/4/1 created
 */
@Mapping("/sev/**")
@Managed
public class SevGateway extends ApiGatewayBase {
    @Override
    protected void register() {
        //添加个前置处理
        filter(new TokenHandler());

        //添加缺省处理
        add(Nav.class);
    }

    public static class Nav {
        //Mapping 值为空的，为缺省处理
        @Mapping
        public Object def(Context ctx) throws Throwable {
            //检测请求，并尝试获取二级接口服务名
            String sevName = ctx.pathMap("/sev/{name}/**").get("name");
            if (sevName == null) {
                throw ApiCodes.CODE_4001011;
            }

            //转发请求
            String rstJson = HttpUtils.http(sevName, ctx.path())
                    .data(ctx.paramMap())
                    .post();

            //将json数据转为 java object
            return ONode.loadStr(rstJson).toData();
        }
    }
}
