package demoB004;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;


/**
 * @author noear 2024/12/6 created
 */
@Controller
public class DemoController {
    @Inject
    private IProducer producer;

    @Mapping("/send")
    public void send(String msg) throws Exception {
        //发送
        producer.send("topic.test", s -> s.createTextMessage("test"));
    }
}
