package demo7012.client;

import org.noear.solon.Solon;
import org.apache.dubbo.solon.annotation.EnableDubbo;

@EnableDubbo
public class DemoDubboConsumeApp {
    public static void main(String[] args) {
        Solon.start(DemoDubboConsumeApp.class, args);

        HelloConsume tmp = Solon.context().getBean(HelloConsume.class);
        System.out.println(tmp.home());
    }
}
