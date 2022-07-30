package demo3036;

import org.noear.solon.Solon;

/**
 * @author noear 2021/6/12 created
 */
public class DemoEnjoyApp {
    public static void main(String[] args) {
        Solon.start(DemoEnjoyApp.class, args)
                .onError(e->e.printStackTrace());
    }
}
