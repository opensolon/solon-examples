package demo1011;

import org.noear.solon.Solon;
import org.noear.solon.extend.hotplug.PluginManager;
import org.noear.solon.schedule.annotation.EnableScheduling;

@EnableScheduling
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);

        //加载插件
        PluginManager.load("add1").start();

        //启动插件
        Solon.global().get("start", ctx -> {
            PluginManager.start("add1");
            ctx.output("OK");
        });

        //停止插件
        Solon.global().get("stop", ctx -> {
            PluginManager.stop("add1");
            ctx.output("OK");
        });
    }
}
