package demo9073.server.controller;

import demo9073.protocol.HelloService;
import demo9073.server.dso.service.UserService;
import org.noear.solon.annotation.Http;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.annotation.Socket;

/**
 * @author noear 2021/6/7 created
 */
@Http
@Socket
@Mapping("/")
@Remoting
public class HelloServiceImpl implements HelloService {

    @Inject
    UserService userService;

    @Override
    public String hello(String name) {
        String name2 = userService.getUser(name);

        userService.updateUser(name);

        return "Hello " + name2;
    }

    @Override
    public String hello2(String name) {
        return "Hello " + name;
    }
}
