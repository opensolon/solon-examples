package demo1021;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Managed;
import org.noear.solon.scheduling.annotation.EnableScheduling;
import org.noear.solon.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author noear 2022/9/10 created
 */
@Slf4j
@EnableScheduling
@Managed
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void test() {
        log.trace("{}", new Date());
        log.debug("{}", new Date());
        log.info("{}", new Date());
        log.warn("{}", new Date());
        log.error("{}", new Date());
    }
}
