package demo3;

import demo3.dso.InitPlugin;
import org.noear.solon.Solon;

/**
 * @author noear 2021/12/28 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            app.pluginAdd(0, new InitPlugin());
        });
    }
}
