package demo5043;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author noear 2022/12/12 created
 */
@Configuration
public class Config {
    @Bean
    public Scheduler jobInit() throws SchedulerException {
        //可以换成别的工厂
        return new StdSchedulerFactory().getScheduler();
    }
}
