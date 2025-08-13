package demo7011.server;

import org.apache.dubbo.solon.annotation.EnableDubbo;
import org.noear.solon.Solon;

@EnableDubbo
public class DubboProviderApp {
    public static void main(String[] args) throws InterruptedException{
        Solon.start(DubboProviderApp.class, args);
    }
}
