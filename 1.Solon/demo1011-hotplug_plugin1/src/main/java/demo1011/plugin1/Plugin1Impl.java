package demo1011.plugin1;

import org.noear.solon.Solon;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;
import org.noear.solon.schedule.JobManager;

/**
 * @Date: 2022/5/15 12:38
 */
public class Plugin1Impl implements Plugin {
    @Override
    public void start(AopContext context) {
        context.beanScan(Plugin1Impl.class);

        System.out.println("插件开启");
    }

    @Override
    public void prestop() throws Throwable {
        //插件内的http处理，用统一的前缀。。。方便移除
        Solon.global().router().remove("/user");

        //定时任务要按名字移除
        JobManager.remove("job1");
    }

    @Override
    public void stop() throws Throwable {
        System.out.println("插件关闭");
    }
}
