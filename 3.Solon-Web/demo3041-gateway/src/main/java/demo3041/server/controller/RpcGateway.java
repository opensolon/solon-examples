package demo3041.server.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Gateway;
import demo3041.server.dso.service.UserServiceImpl;

/**
 * 内部RPC调用模式
 *
 * @author noear 2021/4/22 created
 */
@Mapping("/api/rpc/**")
@Component
public class RpcGateway extends Gateway {
    @Override
    protected void register() {
        before(c -> c.attrSet("@render", "@type_json"));

        //添加服务（不带mapping的函数；需要 remoting = true，才会加载出来）
        add("user", UserServiceImpl.class, true);
    }

//    也可以直接修改宣染
//
//    @Override
//    public void render(Object obj, Context c) throws Throwable {
//        c.outputAsJson(ONode.serialize(obj));
//    }
}
