package demo8003.server;

import org.noear.solon.Solon;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args, app -> {
            app.enableSocketD(true);
        });
    }
}
