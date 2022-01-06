package demo8051.protocol;

import org.noear.nami.annotation.NamiClient;

@NamiClient(name = "demo", path = "/demoe/rpc/name")
public interface NameService {
    String name(String name);
}
