package demo9021.server.controller;

import demo9021.protocol.HelloService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;

/**
 * @author noear 2021/1/8 created
 */
@Mapping("/rpc/")
@Remoting
public class HelloServiceRemoteImp implements HelloService {
    @Override
    public String hello() {
        return "remote: hello";
    }
}
