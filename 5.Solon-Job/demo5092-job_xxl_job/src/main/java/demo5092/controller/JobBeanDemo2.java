package demo5092.controller;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.noear.solon.annotation.Managed;
import org.noear.solon.cloud.annotation.CloudJob;

/**
 * @author noear 2021/5/25 created
 */
@Managed
public class JobBeanDemo2 {
    @CloudJob("JobBeanDemo2-1")
    public void test(){
        System.out.println("JobBeanDemo2-1");
    }

    @XxlJob("JobBeanDemo2-2")
    public void test2(){
        System.out.println("JobBeanDemo2-2");
    }
}
