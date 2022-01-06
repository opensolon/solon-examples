package demo8042.protocol;

import org.noear.nami.annotation.NamiClient;
import org.noear.solon.socketd.annotation.Handshake;

@NamiClient(name = "demo", path = "/demoe/rpc")
public interface HelloService {
    @Handshake
    boolean auth(String sn, String token);

    String hello(String name);
}
