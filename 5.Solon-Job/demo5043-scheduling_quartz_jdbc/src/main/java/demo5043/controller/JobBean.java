package demo5043.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Managed;
import org.noear.solon.scheduling.annotation.Scheduled;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @author noear 2021/12/28 created
 */
@Slf4j
@Managed
public class JobBean {
    @Scheduled(fixedRate = 1000 * 3)
    public void job11(){
        log.warn(new Date() + ": 1000*3");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "+02")
    public void job12(JobExecutionContext jobContext){
        System.out.println(ONode.stringify(jobContext));
        log.warn(new Date() + ": 0/10 * * * * ? *");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "CET")
    public void job13(){
        log.warn(new Date() + ": 0/10 * * * * ? *");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "Asia/Shanghai")
    public void job14(){
        log.warn(new Date() + ": 0/10 * * * * ? *");
    }
}
