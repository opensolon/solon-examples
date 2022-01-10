package demo4041;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import org.noear.solon.Solon;

/**
 * @author noear 2021/5/24 created
 */
public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class, args, app -> {
            app.onEvent(ActiveRecordPlugin.class, arp -> {
                //启用开发模式
                if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                    arp.setDevMode(true);
                }
            });
        });
    }
}
