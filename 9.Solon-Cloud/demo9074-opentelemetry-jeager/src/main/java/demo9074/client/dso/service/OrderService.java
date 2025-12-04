package demo9074.client.dso.service;

import org.noear.solon.annotation.Managed;
import org.noear.solon.cloud.telemetry.Spans;
import org.noear.solon.cloud.telemetry.annotation.Tracing;

/**
 * @author noear 2022/5/7 created
 */
@Managed
public class OrderService {
    @Tracing(tags = "订单=${orderId}")
    public void orderCreate(String orderId) {
        Spans.active(span -> span.setAttribute("用户", 1));

        System.out.println("print - test");
    }
}
