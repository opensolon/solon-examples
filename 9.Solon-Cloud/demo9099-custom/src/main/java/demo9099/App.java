package demo9099;

import demo9099.dso.cloud.XPluginImpl;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * @author noear 2023/4/13 created
 */
@SolonMain
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            //优先级高些 //或者通过 plugin spi 模式配置
            app.pluginAdd(99, new XPluginImpl());
        });
    }
}
