package demo1011.plugin1.controller;

import org.noear.solon.schedule.annotation.Scheduled;

import java.util.Date;

/**
 * @author noear 2022/5/15 created
 */
@Scheduled(name = "job1",fixedRate = 1000 * 3)
public class JobTest implements Runnable {
    @Override
    public void run() {
        System.out.println(new Date() + ": 1000*3");
    }
}

