package demo8003.server;

import demo8003.utils.EncryptUtils;
import org.noear.solon.Solon;
import org.noear.solon.socketd.SocketD;
import org.noear.solon.socketd.protocol.MessageProtocolSecret;

public class ServerDemo {
    public static void main(String[] args) {
        Solon.start(ServerDemo.class, args, app -> {
            app.enableSocketD(true);

            //使用压缩协议； 启用压缩协议（默认超过1k才进行压缩，可以自己改改）::要与客户端配套启用
            //SocketD.setProtocol(new MessageProtocolCompress());
            //使用压缩后再加密协议；
            //SocketD.setProtocol(new MessageProtocolSecret(new MessageProtocolCompress()));

            //使用加密协议
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
