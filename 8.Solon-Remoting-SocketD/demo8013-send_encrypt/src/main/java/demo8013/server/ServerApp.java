package demo8013.server;

import org.noear.solon.Solon;
import org.noear.solon.socketd.SocketD;
import org.noear.solon.socketd.protocol.MessageProtocolSecret;

//启动服务端
public class ServerApp {
    public static void main(String[] args) {
        //启动Solon容器（SocketD bean&plugin 由solon容器管理）
        Solon.start(ServerApp.class, args, app -> {
            app.enableSocketD(true);
            app.enableSocketMvc(true);

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
    }
}
