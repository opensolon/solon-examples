package client.dso;

import demo9023.protocol.HelloService;
import org.noear.solon.annotation.Managed;

/**
 * @author noear 2020/12/29 created
 */
@Managed
public class HelloServiceLocalImp implements HelloService {
    @Override
    public String hello() {
        return "local: hello";
    }
}
