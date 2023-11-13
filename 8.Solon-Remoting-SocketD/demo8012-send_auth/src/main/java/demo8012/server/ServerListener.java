package demo8012.server;

import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.solon.Utils;
import org.noear.solon.net.annotation.ServerEndpoint;

import java.io.IOException;
import java.util.Map;

//定义服务端监听
@ServerEndpoint
public class ServerListener extends SimpleListener {
    @Override
    public void onOpen(Session session) throws IOException{
        System.out.println("有客户端链上来喽...");

        if("1".equals(session.param("sn")) && "1".equals(session.param("token"))){
            System.out.println("鉴权通过！");
        }else{
            session.close();
        }
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        onMessage0(session, message);
    }

    private void onMessage0(Session session, Message message) throws IOException {
        //业务处理
        System.out.println("服务端：我收到：" + message.dataAsString());
    }
}
