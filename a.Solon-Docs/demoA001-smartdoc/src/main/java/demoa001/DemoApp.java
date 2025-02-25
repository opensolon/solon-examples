package demoa001;

import org.noear.solon.Solon;

public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class, args).get("/", c -> {
            //只是为了演示，跳过去方便
            c.redirect("/doc/api.html");
        });
    }
}
