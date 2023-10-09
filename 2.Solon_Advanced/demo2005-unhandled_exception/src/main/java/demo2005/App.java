package demo2005;

import org.noear.solon.Solon;
import org.noear.solon.SolonBuilder;

/**
 * @author noear 2022/1/7 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }

    public static void main2(String[] args) {
        Solon.start(App.class, args);
    }

    public static void main3(String[] args) {
        //在 start 之前进行订阅
        new SolonBuilder().start(App.class, args);
    }
}
