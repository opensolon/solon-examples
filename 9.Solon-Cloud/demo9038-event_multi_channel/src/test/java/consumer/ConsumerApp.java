package consumer;

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
public class ConsumerApp {
    public static void main(String[] args) {
        Solon.start(ConsumerApp.class, args, app -> {
            app.pluginAdd(0, new EventPlugin());
        });
    }

    public static class EventPlugin implements Plugin {
        @Override
        public void start(SolonApp app) {
            CloudProps cloudProps = new CloudProps("rabbitmq_biz");
            CloudEventServiceRabbitmqImp eventServiceImp = new CloudEventServiceRabbitmqImp(cloudProps);
            CloudManager.register(eventServiceImp);

            Aop.beanOnloaded(eventServiceImp::subscribe);
        }
    }
}