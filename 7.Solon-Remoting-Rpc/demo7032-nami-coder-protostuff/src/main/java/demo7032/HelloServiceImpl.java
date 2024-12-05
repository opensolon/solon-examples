package demo7032;

import org.noear.solon.annotation.Body;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;

@Mapping("/rpc/demo")
@Remoting
public class HelloServiceImpl implements HelloService {
    @Override
    public MessageDo hello(@Body MessageDo order) {
        System.out.println(order);

        return order;
    }
}