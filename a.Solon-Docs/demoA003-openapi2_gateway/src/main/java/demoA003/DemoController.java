package demoA003;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2024/8/19 created
 */
@Controller
public class DemoController {
    @Mapping("hello")
    public String hello(String name) {
        return "hello " + name;
    }
}
