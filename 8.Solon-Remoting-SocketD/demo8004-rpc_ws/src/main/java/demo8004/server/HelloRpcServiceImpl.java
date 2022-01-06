package demo8004.server;

import demo8004.service.HelloRpcService;
import demo8004.service.NameRpcService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.socketd.SocketD;
//
//注意method的区别（也可以同时加 SOCKET 和 WEBSOCKET）
//
@Mapping(value = "/demoe/rpc", method = MethodType.WEBSOCKET)
@Remoting
public class HelloRpcServiceImpl implements HelloRpcService {
    public String hello(String name) {
        //
        //[服务端] 调用 [客户端] 的 rpc
        //
        NameRpcService rpc = SocketD.create(Context.current(), NameRpcService.class);
        name = rpc.name(name);

        return "name=" + name;
    }
}
