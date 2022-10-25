package demo1011;

import org.noear.solon.Solon;
import org.noear.solon.hotplug.PluginManager;
import org.noear.solon.schedule.annotation.EnableScheduling;

@EnableScheduling
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            //启动插件
            app.get("start", ctx -> {
                PluginManager.start("add1");
                ctx.output("OK");
            });

            //停止插件
            app.get("stop", ctx -> {
                PluginManager.stop("add1");
                ctx.output("OK");
            });

            //卸载插件
            app.get("unload", ctx -> {
                PluginManager.unload("add1");
                ctx.output("OK");
            });
        });

        //加载插件
        PluginManager.load("add1").start();
    }
}
