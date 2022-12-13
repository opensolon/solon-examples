package demo9024.server.controller;

import demo9024.protocol.HelloService;
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
