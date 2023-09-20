package demo8042.server;

import org.noear.solon.Solon;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.MessageFlag;
import org.noear.solon.core.message.Session;

import java.io.IOException;

//启动服务端
public class ServerApp {
    public static void main(String[] args) {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ServerApp.class, args, app -> {
            app.enableSocketD(true);
            app.enableSocketMvc(true);

            app.socket("**", new Listener() {
                @Override
                public void onMessage(Session session, Message message) throws IOException {
                    if (message.flag() != MessageFlag.handshake) {
                        if (session.getHandshaked() == false) {
                            System.out.println("这个客户端很坏，没签权就想发包:(");
                            session.close();
                        }
                    }
                }
            });
        });

        //.socket(..) 可替代 @ServerEndpoint 使用
    }
}