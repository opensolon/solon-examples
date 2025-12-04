package demo9074.server.controller;

import demo9074.protocol.HelloService;
import demo9074.server.dso.service.UserService;
import org.noear.solon.annotation.*;
import org.noear.solon.cloud.telemetry.slf4j.TracingMDC;
import org.slf4j.MDC;

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

        System.out.println(TracingMDC.TRACE_ID_NAME + ": " + MDC.get(TracingMDC.TRACE_ID_NAME));


        String name2 = userService.getUser(name);

        userService.updateUser(name);

        return "Hello " + name2;
    }

    @Override
    public String hello2(String name) {
        return "Hello " + name;
    }
}
