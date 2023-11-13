package client;

import demo8001.server.ServerApp;
import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.solon.Solon;

import java.io.IOException;

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

        //
        //手动模式：适用于服务端不固定的
        //
        //ws://
        //wss://
        //tcp://
        //
        Session session = SocketD.createClient("tcp://localhost:28080")
                .listen(new SimpleListener(){
                    @Override
                    public void onOpen(Session session) {
                        System.out.println("客户端1：我要打开了...");
                    }

                    @Override
                    public void onMessage(Session session, Message message) throws IOException {
                        //
                        // message.body 要自己解码一下；如果是字符串，可以：message.toString();
                        //
                        System.out.println("客户端1：我收到了：" + message);

                        session.send("demo" ,new StringEntity("test"));
                    }
                })
                .open();

        session.send("/demo", new StringEntity("test"));

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
