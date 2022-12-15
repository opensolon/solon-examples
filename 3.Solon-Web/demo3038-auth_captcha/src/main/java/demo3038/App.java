package demo3038;

import org.noear.solon.Solon;
import org.noear.solon.web.cors.CrossHandler;

/**
 * @author noear 2022/12/15 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            app.before(-1, new CrossHandler());
            app.get("/", c -> c.redirect("/index.html"));
        });
    }
}
