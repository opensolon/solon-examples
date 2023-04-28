package demo5042.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.scheduling.annotation.Scheduled;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @author noear 2021/12/28 created
 */
@Slf4j
@Component
public class JobBean {
    @Scheduled(fixedRate = 1000 * 3)
    public void job11(){
        log.trace(new Date() + ": 1000*3");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "+02")
    public void job12(JobExecutionContext jobContext){
        System.out.println(ONode.stringify(jobContext));
        log.trace(new Date() + ": 0/10 * * * * ? *");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "CET")
    public void job13(){
        log.trace(new Date() + ": 0/10 * * * * ? *");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "Asia/Shanghai")
    public void job14(){
        log.trace(new Date() + ": 0/10 * * * * ? *");
    }
}
