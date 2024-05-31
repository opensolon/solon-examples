package demo7013;

import io.grpc.solon.annotation.EnableGrpc;
import org.noear.solon.Solon;

/**
 * @author noear 2022/6/20 created
 */
@EnableGrpc
public class DemoApp {
    public static void main(String[] args) throws Exception {
        Solon.start(DemoApp.class, args);
    }
}
