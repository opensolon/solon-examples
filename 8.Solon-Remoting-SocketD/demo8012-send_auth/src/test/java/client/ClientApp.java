package client;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.solon.Solon;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ClientApp.class, args);

        //创建会话（如果后端是WebSocekt，协议头为：ws）
        Session session = SocketD.createClient("tcp://localhost:28080?sn=1&token=1").open();

        //上报消息
        session.send("demo", new StringEntity("Helloworld server!"));
    }
}
