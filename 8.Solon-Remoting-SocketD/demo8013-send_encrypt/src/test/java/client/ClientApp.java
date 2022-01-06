package client;

import org.noear.solon.Solon;
import org.noear.solon.core.message.Session;
import org.noear.solon.socketd.SocketD;
import org.noear.solon.socketd.protocol.MessageProtocolSecret;

//启动客户端
public class ClientApp {
    public static void main(String[] args) throws Throwable {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ClientApp.class, args, app->{
            //设置加强协议，使用加密协议（服务端也要一同设置）
            SocketD.setProtocol(new MessageProtocolSecret() {
                @Override
                public byte[] encrypt(byte[] bytes) throws Exception {
                    return EncryptUtils.aesEncrypt(bytes,"pLft36Ok5zfmP6zI");
                }

                @Override
                public byte[] decrypt(byte[] bytes) throws Exception {
                    return EncryptUtils.aesDecrypt(bytes,"pLft36Ok5zfmP6zI");
                }
            });
        });

        //创建会话（如果后端是WebSocekt，协议头为：ws）
        Session session = SocketD.createSession("tcp://localhost:28080");

        //设定30秒自动上发心跳（如果断开了，也尝试自动重链）
        session.sendHeartbeatAuto(30);

        //上报消息
        session.send("Helloworld server!");
    }
}
