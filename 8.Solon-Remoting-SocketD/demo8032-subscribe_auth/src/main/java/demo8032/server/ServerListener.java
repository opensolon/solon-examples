package demo8032.server;

import org.noear.solon.Utils;
import org.noear.solon.annotation.ServerEndpoint;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.MessageFlag;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.util.HeaderUtil;

import java.io.IOException;
import java.util.Map;

//定义服务端监听
@ServerEndpoint
public class ServerListener implements Listener {
    @Override
    public void onOpen(Session session) {
        System.out.println("有客户端链上来喽...");
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        if (session.getHandshaked() == false) {
            //消息是线程池分发的，确保鉴权时的消息顺序锁一下
            synchronized (session) {
                onMessage0(session, message);
            }
        } else {
            onMessage0(session, message);
        }
    }

    private void onMessage0(Session session, Message message) throws IOException {
        //如果是握手，则做鉴权处理
        if (message.flag() == MessageFlag.handshake) {
            if (Utils.isEmpty(message.header())) {
                session.close();
            } else {
                Map<String, String> headers = HeaderUtil.decodeHeaderMap(message.header());
                if ("1".equals(headers.get("token"))) {
                    //如果token是1，则设为成功握手
                    System.out.println("签权成功");
                    session.setHandshaked(true);
                } else {
                    session.close();
                }
            }
        } else {
            //没有握手成功之前，不能做别的事；且自动断开链接
            if (session.getHandshaked() == false) {
                System.out.println("这个客户端很坏，没签权就想发包:(");
                session.close();
            }
        }
    }
}
