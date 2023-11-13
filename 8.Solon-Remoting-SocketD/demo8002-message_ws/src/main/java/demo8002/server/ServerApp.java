package demo8002.server;

import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.solon.Solon;

import java.util.concurrent.CompletableFuture;

public class ServerApp {
    public static CompletableFuture<Boolean> status = new CompletableFuture<>();

    public static void main(String[] args) throws Throwable {
        //
        //smarthttp 自带了 websocket服务，与http同用8080端口
        //
        Solon.start(ServerApp.class, args, app -> {
            app.enableWebSocket(true);
        });

        //
        // 此处只为演示需要；实际诮和不需要这个
        //
        if (status.get()) {
            //再待一秒，或许有更多会话边中来
            Thread.sleep(500);

            for (Session s1 : ServerListener.getOpenSessions()) {
                s1.send("demo", new StringEntity("配置是：1"));
            }
        }
    }
}
