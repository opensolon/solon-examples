package demo8042.server;

import org.noear.solon.Solon;
import org.noear.solon.core.message.MessageFlag;

//启动服务端
public class ServerApp {
    public static void main(String[] args) {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ServerApp.class, args, app -> app.enableSocketD(true))
                .socket("**", (session, message) -> {
                    if (message.flag() != MessageFlag.handshake) {
                        if (session.getHandshaked() == false) {
                            System.out.println("这个客户端很坏，没签权就想发包:(");
                            session.close();
                        }
                    }
                });

        //.socket(..) 可替代 @ServerEndpoint 使用
    }
}