package consumer.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.annotation.Socket;

/**
 * @author noear 2024/2/28 created
 */
@Controller
public class TestRpc {
    @Mapping("/rpc/hello")
    public String hello(String name) {
        if("e".equals(name)){
            throw new IllegalStateException("ddd");
        }

        return name + ":me to!";
    }
}
