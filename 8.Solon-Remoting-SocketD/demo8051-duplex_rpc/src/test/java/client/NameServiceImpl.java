package client;

import demo8051.protocol.NameService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.annotation.Socket;

//定义远程服务组件（供服务端调用）
@Socket
@Mapping("/demoe/rpc/name")
@Remoting
public class NameServiceImpl implements NameService {
    @Override
    public String name(String name) {
        return name + "2";
    }
}
