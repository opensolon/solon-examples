package demo9013.dso;

import demo9012.protocol.HelloService;
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
