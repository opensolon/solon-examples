package demo3011;

import org.noear.solon.Solon;

public class WebApp {
    public static void main(String[] args) {
        Solon.start(WebApp.class, args, app -> {
            app.onError(e -> e.printStackTrace());
        });
    }
}
