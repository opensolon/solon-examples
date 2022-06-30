package demo7012.server;

import org.noear.solon.Solon;
import org.noear.solon.extend.dubbo.EnableDubbo;

@EnableDubbo
public class DemoDubboProviderApp {
    public static void main(String[] args) throws Throwable{
        Solon.start(DemoDubboProviderApp.class, args);
    }
}
