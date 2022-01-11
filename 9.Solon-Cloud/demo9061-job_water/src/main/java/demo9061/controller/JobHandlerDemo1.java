package demo9061.controller;

import org.noear.solon.cloud.CloudJobHandler;
import org.noear.solon.cloud.annotation.CloudJob;
import org.noear.solon.core.handle.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear 2021/5/25 created
 */
@CloudJob(name = "JobHandlerDemo1", cron7x = "0 * * * * ?")
public class JobHandlerDemo1 implements CloudJobHandler {
    static final Logger log = LoggerFactory.getLogger(JobBeanDemo2.class);

    @Override
    public void handle(Context ctx) throws Throwable {
        log.info("JobHandlerDemo1");
    }
}
