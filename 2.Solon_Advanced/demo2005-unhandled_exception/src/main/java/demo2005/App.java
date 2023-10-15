package demo2005;

import org.noear.solon.Solon;
import org.noear.solon.core.event.AppInitEndEvent;

/**
 * @author noear 2022/1/7 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }

    public static void main2(String[] args) {
        Solon.start(App.class, args, app -> {
            //初始化时，手动订阅
            app.onEvent(AppInitEndEvent.class, e -> {

            });
        });
    }
}
