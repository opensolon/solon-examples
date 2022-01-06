package demo5011;

import org.noear.solon.Solon;
import org.noear.solon.schedule.annotation.EnableScheduling;

/**
 * @author noear 2022/1/6 created
 */
@EnableScheduling
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args);
    }
}
