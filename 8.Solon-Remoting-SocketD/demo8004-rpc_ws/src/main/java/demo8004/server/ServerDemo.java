package demo8004.server;

import org.noear.solon.Solon;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args,  app -> {
            app.enableHttp(true);
            app.enableWebSocket(true);
            app.enableSocketD(true);
        });
    }
}
