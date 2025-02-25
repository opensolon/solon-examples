package demoB001;

import org.noear.solon.Solon;
import org.noear.solon.scheduling.annotation.EnableScheduling;

/**
 * @author noear 2024/12/6 created
 */
@EnableScheduling
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}
