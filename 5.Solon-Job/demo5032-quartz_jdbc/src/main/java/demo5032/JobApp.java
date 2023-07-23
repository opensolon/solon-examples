package demo5032;

import org.noear.solon.Solon;
import org.noear.solon.extend.quartz.EnableQuartz;

@EnableQuartz
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args);
    }
}
