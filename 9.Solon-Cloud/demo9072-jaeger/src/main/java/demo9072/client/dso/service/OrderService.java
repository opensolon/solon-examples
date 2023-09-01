package demo9072.client.dso.service;

import org.noear.solon.cloud.tracing.Spans;
import org.noear.solon.cloud.tracing.annotation.Tracing;
import org.noear.solon.annotation.Component;

/**
 * @author noear 2022/5/7 created
 */
@Component
public class OrderService {
    @Tracing(name = "创建订单", tags = "订单=${orderId}")
    public void orderCreate(String orderId) {
        Spans.active(span -> span.setTag("用户", 1));

        System.out.println("print - test");
    }
}
