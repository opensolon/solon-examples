package demo.controller;


import org.noear.solon.net.annotation.ServerEndpoint;
import org.noear.solon.net.websocket.WebSocket;
import org.noear.solon.net.websocket.listener.SimpleWebSocketListener;

import java.io.IOException;

/**
 * @author noear 2021/4/22 created
 * @since 2.6
 */
@ServerEndpoint("/ws/demo/{id}")
public class WebSocketImpl extends SimpleWebSocketListener {
    @Override
    public void onOpen(WebSocket session) {
        //path var
        String id = session.param("id");
        //query var
        String token = session.param("token");

        /*此处可以做签权；会话的二次组织等...*/
    }

    @Override
    public void onMessage(WebSocket session, String message) throws IOException {
        //message.setHandled(true); //设为true，则不进入mvc路由

        session.send("你发了：" + message);
    }

    @Override
    public void onClose(WebSocket session) {
        System.out.println("onClose");
    }

    @Override
    public void onError(WebSocket session, Throwable error) {
        System.out.println("onError");
        if (error != null) {
            error.printStackTrace();
        }
    }
}
