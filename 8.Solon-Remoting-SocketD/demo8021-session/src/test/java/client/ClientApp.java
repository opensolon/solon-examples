package client;

import org.noear.solon.Solon;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.SocketD;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ClientApp.class, args);

        //创建会话（如果后端是WebSocekt，协议头为：ws）
        Session session = SocketD.createSession("tcp://localhost:28080");

        //设定30秒自动上发心跳（如果断开了，也尝试自动重链）
        session.sendHeartbeatAuto(30);

        //发消息并等结果
        String message = session.sendAndResponse("Helloworld server!");
        System.out.println("客户端：我收到：" + message);
    }
}
