package demo9074.protocol;

import org.noear.nami.annotation.NamiClient;

/**
 * @author noear 2021/6/7 created
 */
@NamiClient(name = "hellorpc")
public interface HelloService {
    String hello(String name);

    String hello2(String name);
}
