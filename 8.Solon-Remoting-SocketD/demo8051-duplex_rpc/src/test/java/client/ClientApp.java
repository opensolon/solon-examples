package client;

import demo8051.protocol.HelloService;
import org.noear.nami.channel.socketd.SocketdProxy;
import org.noear.solon.Solon;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ClientApp.class, args);

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloService rpc = SocketdProxy.create("tcp://localhost:28080/", HelloService.class);

        System.out.println("RPC result: " + rpc.hello("noear"));
    }
}
