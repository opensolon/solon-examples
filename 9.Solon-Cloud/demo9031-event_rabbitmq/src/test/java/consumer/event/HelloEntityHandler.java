package consumer.event;

import org.noear.solon.cloud.extend.cloudeventplus.CloudEventHandlerPlus;
import org.noear.solon.cloud.extend.cloudeventplus.CloudEventSubscribe;

/**
 * @author noear 2021/11/5 created
 */
@CloudEventSubscribe
public class HelloEntityHandler implements CloudEventHandlerPlus<HelloEntity> {

    @Override
    public boolean handle(HelloEntity event) throws Throwable {
        System.out.println("HelloEntityHandler:: " + event.name);
        return true;
    }
}
