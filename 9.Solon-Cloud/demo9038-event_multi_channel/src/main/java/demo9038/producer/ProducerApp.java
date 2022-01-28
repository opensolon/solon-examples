package demo9038.producer;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.cloud.CloudManager;
import org.noear.solon.cloud.CloudProps;
import org.noear.solon.cloud.extend.rabbitmq.service.CloudEventServiceRabbitmqImp;
import org.noear.solon.core.Aop;
import org.noear.solon.core.Plugin;

/**
 * @author noear 2021/1/27 created
 */
public class ProducerApp {
    public static void main(String[] args) {
        Solon.start(ProducerApp.class, args, app -> {
            app.pluginAdd(0, new EventPlugin());
        });
    }

    public static class EventPlugin implements Plugin {
        @Override
        public void start(SolonApp app) {
            //获取配置块
            CloudProps cloudProps = new CloudProps("rabbitmq_biz");
            //初始化服务
            CloudEventServiceRabbitmqImp eventServiceImp = new CloudEventServiceRabbitmqImp(cloudProps);
            //注册
            CloudManager.register(eventServiceImp);
            //触发订阅动作
            Aop.beanOnloaded(eventServiceImp::subscribe);
        }
    }
}
