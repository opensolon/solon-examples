package demo.controller;

import org.noear.solon.annotation.ServerEndpoint;
import org.noear.solon.core.message.Listener;
import org.noear.solon.core.message.Message;
import org.noear.solon.core.message.Session;

import java.io.IOException;

/**
 * @author noear 2021/4/22 created
 */
@ServerEndpoint(value = "/ws/demo/{id}")
public class WebSocket implements Listener {
    @Override
    public void onOpen(Session session) {
        //path var
        String id = session.param("id");
        //query var
        String token = session.param("token");

        /*此处可以做签权；会话的二次组织等...*/
    }

    @Override
    public void onMessage(Session session, Message message) throws IOException {
        //message.setHandled(true); //设为true，则不进入mvc路由

        session.send("你发了：" + message.bodyAsString());
    }
}
