package demo8011.server;

import org.noear.solon.Solon;

//启动服务端
public class ServerApp {
    public static void main(String[] args) {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ServerApp.class, args, app -> app.enableSocketD(true));
    }
}
