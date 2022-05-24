package demo1011.controller;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2022/5/17 created
 */
@Mapping("order")
@Controller
public class OrderController {
    @Mapping("t1")
    public String t1(){
        return Solon.cfg().appName();
    }
}
