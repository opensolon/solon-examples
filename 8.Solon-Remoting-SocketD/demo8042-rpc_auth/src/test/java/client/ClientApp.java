package client;

import demo8042.protocol.HelloService;
import org.noear.solon.Solon;
import org.noear.solon.socketd.SocketD;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ClientApp.class, args);

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloService rpc = SocketD.create("tcp://localhost:28080", HelloService.class);

        if (rpc.auth("1", "1")) {
            System.out.println("RPC result: " + rpc.hello("noear"));
        }

    }
}
