package demo7011.client;

import org.apache.dubbo.config.annotation.Reference;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.apache.dubbo.solon.annotation.EnableDubbo;
import demo7011.protocol.HelloService;

@EnableDubbo
@Controller
public class DubboConsumeApp {
    public static void main(String[] args) {
        Solon.start(DubboConsumeApp.class, args, app -> app.enableHttp(false));

        //通过手动模式直接拉取bean
        DubboConsumeApp tmp = Solon.context().getBean(DubboConsumeApp.class);
        System.out.println(tmp.home());
    }

    @Reference(group = "demo")
    HelloService helloService;

    @Mapping("/")
    public String home() {
        return helloService.sayHello("noear");
    }
}
