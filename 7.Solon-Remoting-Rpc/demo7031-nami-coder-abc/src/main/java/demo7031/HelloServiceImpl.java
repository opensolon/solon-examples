package demo7031;

import org.noear.solon.annotation.Body;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;

@Mapping("/rpc/hello")
@Remoting
public class HelloServiceImpl implements HelloService {
    @Override
    public OrderDo hello(@Body OrderDo order) {
        System.out.println(order);

        return order;
    }
}