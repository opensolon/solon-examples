package demo1011;

import org.noear.solon.Solon;
import org.noear.solon.hotplug.PluginManager;
import org.noear.solon.hotplug.PluginPackage;

import java.io.File;

/**
 * @author noear 2022/5/18 created
 */
public class App2Demo {


    /**
     * 方案1：基于配置 + name 进行控制
     * */
    public static void main1(String[] args) {

        Solon.start(App.class, args, app->{
            //移除插件
            app.get("del", ctx -> {
                PluginManager.unload("add1");
                ctx.output("OK");
            });
        });

        //加载插件，并启动
        PluginManager.load("add1").start();
    }

    /**
     * 方案2：直接通过 jar 操作
     * */
    public static void main2(String[] args) {

        Solon.start(App.class, args);

        File file = new File("/Users/noear/Downloads/test/test2/target/test2.jar");

        //加载插件，并启动
        PluginPackage pluginPackage = PluginManager.loadJar(file).start();

        //移除插件
        Solon.app().get("del", ctx -> {
            PluginManager.unloadJar(pluginPackage);
            ctx.output("OK");
        });
    }
}
