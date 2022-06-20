package demo7013.client;

import org.noear.solon.Solon;
import org.noear.solon.extend.grpc.annotation.EnableGrpc;

/**
 * @author noear 2022/6/20 created
 */
@EnableGrpc
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}