package client;

import demo8003.service.NameRpcService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.core.handle.MethodType;

@Mapping(value = "/demoe/rpc/name", method = MethodType.SOCKET)
@Remoting
public class NameRpcServiceImpl implements NameRpcService {
    @Override
    public String name(String name) {
        return name;
    }
}
