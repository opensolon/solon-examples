package client;

import demo8041.protocol.HelloService;
import org.noear.nami.Nami;
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
        System.out.println("RPC result: " + rpc.hello("noear"));


        HelloService rpc2 = Nami.builder().url("tcp://localhost:28080/demoe/rpc").create(HelloService.class);
        System.out.println("RPC result2: " + rpc2.hello("noear"));

        HelloService rpc3 = Nami.builder().upstream(()->"tcp://localhost:28080").create(HelloService.class);
        System.out.println("RPC result3: " + rpc3.hello("noear"));
    }
}
