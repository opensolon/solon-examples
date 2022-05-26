package demo1011.plugin1;

import org.noear.solon.Solon;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;
import org.noear.solon.core.event.EventBus;
import org.noear.solon.core.event.EventListener;
import org.noear.solon.extend.staticfiles.StaticMappings;
import org.noear.solon.extend.staticfiles.StaticRepository;
import org.noear.solon.extend.staticfiles.repository.ClassPathStaticRepository;
import org.noear.solon.schedule.JobManager;

/**
 * @Date: 2022/5/15 12:38
 */
public class Plugin1Impl implements Plugin {
    AopContext context;
    StaticRepository staticRepository;

    @Override
    public void start(AopContext context) {
        this.context = context;

        //扫描bean
        context.beanScan(Plugin1Impl.class);

        //添加静态文件仓库
        staticRepository = new ClassPathStaticRepository(context.getClassLoader(),"static");
        StaticMappings.add("/", staticRepository);

        System.out.println("插件开启");
    }

    @Override
    public void stop() throws Throwable {
        //移除http处理。//用前缀，方便移除
        Solon.app().router().remove("/user");

        //移除定时任务
        JobManager.remove("job1");

        //移除事件订阅
        context.beanForeach(bw -> {
            if (bw.raw() instanceof EventListener) {
                EventBus.unsubscribe(bw.raw());
            }
        });

        //移除静态文件仓库
        StaticMappings.remove(staticRepository);


        System.out.println("插件关闭");
    }
}
