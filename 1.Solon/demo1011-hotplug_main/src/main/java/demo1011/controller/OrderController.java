package demo1011.controller;

import demo1011.common.event.OrderCreatedEvent;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.event.EventBus;

/**
 * @author noear 2022/5/17 created
 */
@Mapping("order")
@Controller
public class OrderController {
    @Mapping("t1")
    public String t1(){
        EventBus.push(new OrderCreatedEvent("t1"));
        return Solon.cfg().appName();
    }
}
