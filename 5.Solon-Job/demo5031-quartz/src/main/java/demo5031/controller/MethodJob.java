package demo5031.controller;

import org.noear.solon.annotation.Managed;
import org.noear.solon.extend.quartz.Quartz;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @author noear 2022/12/1 created
 */
@Managed
public class MethodJob {
    @Quartz(cron7x = "* * * * * ?")
    public void job4(){
        System.out.println("job4: " + new Date());
    }

    @Quartz(cron7x = "* * * * * ?")
    public void job5(JobExecutionContext ctx){
        System.out.println("job5: " + ctx.getJobDetail().getKey().getName());
        System.out.println("job5: " + new Date());
    }
}
