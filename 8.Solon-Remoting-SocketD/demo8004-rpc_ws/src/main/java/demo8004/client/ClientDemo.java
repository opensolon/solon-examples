package demo8004.client;

import demo8004.service.HelloRpcService;
import org.noear.solon.Solon;
import org.noear.solon.socketd.SocketD;

public class ClientDemo {
    public static void main(String[] args) {
        Solon.start(ClientDemo.class, args,
                app -> app.enableHttp(false).enableWebSocketD(true));

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloRpcService rpc = SocketD.create("ws://localhost:8080", HelloRpcService.class);

        System.out.println("RPC result:: " + rpc.hello("noear"));
    }
}
