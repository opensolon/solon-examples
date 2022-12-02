package demo5041;

import org.noear.solon.Solon;
import org.noear.solon.scheduling.annotation.EnableScheduling;

/**
 * @author noear 2022/1/6 created
 */
@EnableScheduling
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args);
    }
}
