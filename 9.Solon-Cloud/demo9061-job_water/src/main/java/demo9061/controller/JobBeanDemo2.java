package demo9061.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.cloud.annotation.CloudJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear 2021/5/25 created
 */

@Component
public class JobBeanDemo2 {
    static final Logger log = LoggerFactory.getLogger(JobBeanDemo2.class);

    @CloudJob("JobBeanDemo2-1")
    public void test(){
        log.info("JobBeanDemo2-1");
    }
}
