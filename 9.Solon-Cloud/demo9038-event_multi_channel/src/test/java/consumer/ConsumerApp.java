package consumer;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.cloud.CloudManager;
import org.noear.solon.cloud.CloudProps;
import org.noear.solon.cloud.extend.rabbitmq.service.CloudEventServiceRabbitmqImp;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;

/**
 * @author noear 2021/1/27 created
 */
public class ConsumerApp {
    public static void main(String[] args) {
        Solon.start(ConsumerApp.class, args, app -> {
            app.pluginAdd(0, new EventPlugin());
        });
    }

    public static class EventPlugin implements Plugin {
        @Override
        public void start(AopContext context) {
            //获取配置块
            CloudProps cloudProps = new CloudProps(context,"rabbitmq_biz");
            //初始化服务
            CloudEventServiceRabbitmqImp eventServiceImp = new CloudEventServiceRabbitmqImp(cloudProps);
            //注册
            CloudManager.register(eventServiceImp);
            //触发订阅动作
            context.beanOnloaded(ctx -> eventServiceImp.subscribe());
        }
    }
}