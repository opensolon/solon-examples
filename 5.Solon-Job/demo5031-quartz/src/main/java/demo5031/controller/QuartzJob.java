package demo5031.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.extend.quartz.Quartz;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

@Slf4j
@Quartz(cron7x = "0 0/1 * * * ? *", name = "job1")
public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {
        log.trace("我是定时任务: QuartzJob(0 0/1 * * * ? *) -- " + new Date().toString());

        log.trace("如果间隔太短，我可能被配置给控制了");
    }
}
