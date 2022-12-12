package demo5032.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.extend.quartz.Quartz;

import java.util.Date;

@Slf4j
@Quartz(cron7x = "0 0/1 * * * ? *")
public class QuartzRun2 implements Runnable {
    @Override
    public void run() {
        log.warn("我是定时任务: QuartzRun2(0 0/1 * * * ? *) -- " + new Date().toString());
    }
}
