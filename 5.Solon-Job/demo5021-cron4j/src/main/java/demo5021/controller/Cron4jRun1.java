package demo5021.controller;


import org.noear.solon.extend.cron4j.Cron4j;

import java.util.Date;

@Cron4j(cron5x = "2s", name = "job1")
public class Cron4jRun1 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是定时任务: Cron4jRun1(2s) -- " + new Date().toString());
        //throw new RuntimeException("异常");
        System.out.println("如果间隔太长，我可能被配置给控制了");
    }
}
