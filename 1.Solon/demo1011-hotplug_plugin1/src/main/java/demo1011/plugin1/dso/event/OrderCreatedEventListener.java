package demo1011.plugin1.dso.event;

import demo1011.common.event.OrderCreatedEvent;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.event.EventListener;

/**
 * @author noear 2022/5/26 created
 */
@Component
public class OrderCreatedEventListener implements EventListener<OrderCreatedEvent> {
    @Override
    public void onEvent(OrderCreatedEvent orderCreatedEvent) throws Throwable {
        System.out.println("收到事件：orderCreatedEvent: " + orderCreatedEvent.getName());
    }
}
