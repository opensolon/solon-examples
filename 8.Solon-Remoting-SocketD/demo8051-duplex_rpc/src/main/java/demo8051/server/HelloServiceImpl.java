package demo8051.server;

import demo8051.protocol.HelloService;
import demo8051.protocol.NameService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.socketd.SocketD;

//定义远程服务组件
@Mapping(value = "/demoe/rpc", method = MethodType.SOCKET)
@Remoting
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        //[服务端] 反向调用 [客户端] 的远程服务组件***
        NameService rpc = SocketD.create(Context.current(), NameService.class);
        name = rpc.name(name);


        return "name=" + name;
    }
}

