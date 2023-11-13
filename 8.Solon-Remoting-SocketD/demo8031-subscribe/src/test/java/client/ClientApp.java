package client;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.SimpleListener;

import java.io.IOException;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        Session session = SocketD.createClient("tcp://localhost:28080")
                .listen(new SimpleListener() {
                    @Override
                    public void onMessage(Session session, Message message) throws IOException {
                        //收到消息，业务处理
                        System.out.println("客户端：我收到了：" + message.dataAsString());
                    }
                })
                .open();
    }
}
