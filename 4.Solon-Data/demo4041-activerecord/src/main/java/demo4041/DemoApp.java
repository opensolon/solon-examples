package demo4041;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import org.noear.solon.Solon;
import org.noear.solon.core.event.PluginLoadEndEvent;
import org.noear.solon.core.handle.RenderManager;

/**
 * @author noear 2021/5/24 created
 */
public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class, args, app -> {
            //订阅事件，后以定制
            app.onEvent(ActiveRecordPlugin.class, arp -> {
                //启用开发或调试模式（可以打印sql）
                if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                    arp.setDevMode(true);
                }
            });
        });
    }
}
