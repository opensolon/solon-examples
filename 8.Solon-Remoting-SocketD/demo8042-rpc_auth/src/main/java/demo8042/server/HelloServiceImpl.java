package demo8042.server;

import demo8042.protocol.HelloService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.core.message.Session;

//定义远程服务组件
@Mapping(value = "/demoe/rpc", method = MethodType.SOCKET)
@Remoting
public class HelloServiceImpl implements HelloService {
    @Override
    public boolean auth(String sn, String token) {
        Session session = (Session) Context.current().request();

        if ("1".equals(token)) {
            session.setHandshaked(true);
            System.out.println("签权成功!");
            return true;
        }else{
            session.setHandshaked(false);
            return false;
        }
    }

    public String hello(String name) {
        return "name=" + name;
    }
}

