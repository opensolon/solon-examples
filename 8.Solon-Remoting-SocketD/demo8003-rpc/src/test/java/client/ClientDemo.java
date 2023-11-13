package client;

import demo8003.service.HelloRpcService;
import org.noear.nami.channel.socketd.SocketdProxy;
import org.noear.solon.Solon;

public class ClientDemo {
    public static void main(String[] args) throws Exception{
        //启动服务端
        //请先手动启动：ServerDemo

        //启动客户端
        Solon.start(ClientDemo.class, args);

        //[客户端] 调用 [服务端] 的 rpc
        //
        HelloRpcService rpc = SocketdProxy.create("tcp://localhost:28080", HelloRpcService.class);

        System.out.println("RPC result: " + rpc.hello("noear"));
    }
}
