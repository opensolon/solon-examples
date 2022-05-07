package demo9071.client.dso.service;

import org.noear.solon.cloud.opentracing.annotation.Tracing;
import org.noear.solon.extend.aspect.annotation.Service;

/**
 * @author noear 2022/5/7 created
 */
@Service
public class OrderService {
    @Tracing(tags = "订单=${orderId}")
    public void orderCreate(String orderId) {
        System.out.println("print - test");
    }
}
