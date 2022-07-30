package demo3037;

import org.noear.solon.Solon;

/**
 * @author noear 2021/6/12 created
 */
public class DemoFreemarkerApp {
    public static void main(String[] args) {
        Solon.start(DemoFreemarkerApp.class, args)
                .onError(e->e.printStackTrace());
    }
}
