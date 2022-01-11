package demo9071.server;

import org.noear.solon.Solon;
import org.noear.solon.cloud.extend.opentracing.annotation.EnableOpentracing;

/**
 * @author noear 2021/6/10 created
 */
@EnableOpentracing
public class DemoRpc {
    public static void main(String[] args) {
        Solon.start(DemoRpc.class, args, app-> app.enableSocketD(true)).onError(e->e.printStackTrace());
    }
}
