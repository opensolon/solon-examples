package demo5032.controller;

import org.noear.solon.extend.quartz.Quartz;

import java.util.Date;

@Quartz(cron7x = "2s" ,name = "QuartzRun1")
public class QuartzRun1 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是定时任务: QuartzRun1(2s) -- " + new Date().toString());
        //throw new RuntimeException("异常");
    }
}
