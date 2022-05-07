package demo9071.client;

import org.noear.solon.Solon;
import org.noear.solon.cloud.extend.opentracing.annotation.EnableTracing;

/**
 * @author noear 2021/6/6 created
 */
@EnableTracing
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}