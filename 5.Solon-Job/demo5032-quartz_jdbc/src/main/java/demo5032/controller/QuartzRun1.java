package demo5032.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.extend.quartz.Quartz;

import java.util.Date;

@Slf4j
@Quartz(cron7x = "2s" ,name = "QuartzRun1")
public class QuartzRun1 implements Runnable {
    @Override
    public void run() {
        log.trace("我是定时任务: QuartzRun1(2s) -- " + new Date().toString());
        //throw new RuntimeException("异常");
    }
}
