package demo9081.controller;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.annotation.CloudBreaker;

/**
 * @author noear 2021/4/26 created
 */

@Controller
public class DemoController {
    @CloudBreaker("hello")
    @Mapping("/")
    public String hello() {
        return "hello";
    }


    @Mapping("/reset")
    public String reset() {
        Solon.cfg().setProperty("solon.cloud.local.breaker.hello", "10");

        return "OK";
    }
}
