package client;

import demo8004.service.NameRpcService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.core.handle.MethodType;

//
//注意method的区别（也可以同时加 SOCKET 和 WEBSOCKET）
//
@Mapping(value = "/demoe/rpc/name", method = {MethodType.WEBSOCKET})
@Remoting
public class NameRpcServiceImpl implements NameRpcService {
    @Override
    public String name(String name) {
        return name;
    }
}
