package demo9092.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.dubbo.EnableDubbo;

@EnableDubbo
public class DubboProviderApp {
    public static void main(String[] args) {
        Solon.start(DubboProviderApp.class, args);
    }
}
