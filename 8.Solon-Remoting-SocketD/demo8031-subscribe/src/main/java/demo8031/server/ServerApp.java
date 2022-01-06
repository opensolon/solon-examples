package demo8031.server;

import org.noear.solon.Solon;

//启动服务端
public class ServerApp {
    public static void main(String[] args) throws Throwable{
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ServerApp.class, args, app -> app.enableSocketD(true));

        //等10秒（先启动ClientApp，再启动ServerApp）
        Thread.sleep(10000);

        //在需要的地方，进行广播（例如：配置服务的更新通知）
        SessionUtil.broadcast("Hello client!");
    }
}
