package demo9071.server;

import org.noear.solon.Solon;
import org.noear.solon.cloud.extend.opentracing.annotation.EnableOpentracing;
import org.noear.solon.cloud.extend.opentracing.annotation.EnableTracing;

/**
 * @author noear 2021/6/10 created
 */
@EnableTracing
public class DemoRpc {
    public static void main(String[] args) {
        Solon.start(DemoRpc.class, args, app-> app.enableSocketD(true)).onError(e->e.printStackTrace());
    }
}
