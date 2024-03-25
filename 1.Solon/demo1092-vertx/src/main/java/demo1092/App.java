package demo1092;

import io.vertx.core.Vertx;
import org.noear.solon.Solon;

/**
 * @author noear 2024/3/25 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app->{
            app.context().wrapAndPut(Vertx.class, Vertx.vertx());
        });
    }
}
