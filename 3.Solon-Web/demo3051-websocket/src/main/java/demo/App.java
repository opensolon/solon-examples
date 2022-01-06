package demo;

import org.noear.solon.Solon;

/**
 * @author noear 2021/4/22 created
 */
public class App {
    public static void main(String[] args) {
        //
        // 启动Solon，并开启WebSocket监听；同时添加/路径跳转
        //
        Solon.start(App.class, args, app -> app.enableWebSocket(true)).get("/", c -> {
            c.redirect("/debug.htm");
        });
    }
}
