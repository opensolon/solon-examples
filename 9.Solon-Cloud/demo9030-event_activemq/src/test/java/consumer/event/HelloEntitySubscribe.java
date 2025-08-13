package consumer.event;

import org.noear.solon.annotation.Managed;
import org.noear.solon.cloud.eventplus.CloudEventSubscribe;

/**
 * @author noear 2021/11/5 created
 */
@Managed
public class HelloEntitySubscribe {
    @CloudEventSubscribe
    public boolean hello(HelloEntity event){
        System.out.println("HelloEntitySubscribe:: " + event.name);
        return true;
    }
}
