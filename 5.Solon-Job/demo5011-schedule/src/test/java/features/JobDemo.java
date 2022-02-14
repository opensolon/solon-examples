package features;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.schedule.annotation.EnableScheduling;
import org.noear.solon.schedule.annotation.Scheduled;

import java.util.Date;

/**
 * @author noear 2022/2/12 created
 */
@Slf4j
@Scheduled(cron = "* * * * * ? *")
@EnableScheduling
public class JobDemo implements Runnable {
    @Override
    public void run() {
        log.info(new Date() + ": * * * * * ? *");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solon.start(JobDemo.class, args);
    }
}
