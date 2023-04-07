package demo9071.client.controller;

import demo9071.client.dso.service.OrderService;
import demo9071.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.tracing.slf4j.TracingMDC;
import org.slf4j.MDC;

/**
 * @author noear 2021/6/7 created
 */
@Controller
public class TestController {
    @NamiClient
    HelloService helloService;

    @Inject
    OrderService orderCreate;

    @Mapping("/")
    public String hello(String name) {
        if (name == null) {
            name = "world";
        }

        System.out.println(TracingMDC.TRACE_ID_NAME + ": " + MDC.get(TracingMDC.TRACE_ID_NAME));


        helloService.hello(name);

        orderCreate.orderCreate("11111");

        return "Rpc: " + helloService.hello2(name);
    }
}
