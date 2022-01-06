package demo5021;

import org.noear.solon.Solon;
import org.noear.solon.extend.cron4j.EnableCron4j;

@EnableCron4j
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args);
    }
}
