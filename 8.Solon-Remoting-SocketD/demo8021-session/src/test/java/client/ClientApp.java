package client;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.solon.Solon;

import java.io.IOException;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ClientApp.class, args);

        //创建会话（如果后端是WebSocekt，协议头为：ws）
        ClientSession session = SocketD.createClient("tcp://localhost:28080")
                .listen(new SimpleListener(){
                    @Override
                    public void onOpen(Session session) {
                        System.out.println("打开222");
                    }

                    @Override
                    public void onMessage(Session session, Message message) throws IOException {

                    }
                })
                .open();


        //发消息并等结果
        Entity message = session.sendAndRequest("demo", new StringEntity("Helloworld server!")).await();
        System.out.println("客户端：我收到：" + message);
    }
}
