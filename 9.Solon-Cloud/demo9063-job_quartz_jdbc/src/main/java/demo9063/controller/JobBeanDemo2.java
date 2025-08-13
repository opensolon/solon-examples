package demo9063.controller;

import org.noear.solon.annotation.Managed;
import org.noear.solon.cloud.annotation.CloudJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear 2021/5/25 created
 */

@Managed
public class JobBeanDemo2 {
    static final Logger log = LoggerFactory.getLogger(JobBeanDemo2.class);

    @CloudJob(name = "JobBeanDemo2-1", cron7x = "2s")
    public void test() {
        log.info("JobBeanDemo2-1");
    }
}
