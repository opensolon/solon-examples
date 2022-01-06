package client;

import demo8001.server.ServerApp;
import org.noear.solon.Solon;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.SocketD;

public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动服务端
        new Thread(()->{
            try {
                ServerApp.main(args);
            }catch (Throwable e){
                throw new RuntimeException(e);
            }
        }).start();

        Thread.sleep(1000 * 3);

        //启动客户端
        Solon.start(ClientApp.class, args);

        //
        //手动模式：适用于服务端不固定的
        //
        //ws://
        //wss://
        //tcp://
        //
        Session session = SocketD.createSession("tcp://localhost:28080");
        session.listener(new Listener() {
            @Override
            public void onOpen(Session session) {
                System.out.println("客户端1：我要打开了...");
            }

            @Override
            public void onMessage(Session session, Message message) {
                //
                // message.body 要自己解码一下；如果是字符串，可以：message.toString();
                //
                System.out.println("客户端1：我收到了：" + message);
            }
        });

        //可以先发个握手包
        //session.sendHandshake("Token=12&Sn=s6");

        //启用自动心跳包
        session.sendHeartbeatAuto(30);

        //示例：有session后，可以：
        //
        //1.异步调用并等待结果
        //Message rst = session.sendAndResponse(MessageWrapper.wrap(null));
        //2.异步调用并回调结果
        //session.sendAndCallback(MessageWrapper.wrap(null), (rst, err) -> {});
        //3.变成RPC客户端
        //HelloService rpc = SocketD.create(session,HelloService.class);


        //卡一下；因为没有任何别的服务启动
        System.in.read();
    }
}
