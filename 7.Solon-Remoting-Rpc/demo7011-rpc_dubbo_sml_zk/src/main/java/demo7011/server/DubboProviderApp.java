package demo7011.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.dubbo.EnableDubbo;

@EnableDubbo
public class DubboProviderApp {
    public static void main(String[] args) throws InterruptedException{
        Solon.start(DubboProviderApp.class, args);
    }
}
