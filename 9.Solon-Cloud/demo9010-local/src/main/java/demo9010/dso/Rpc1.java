package demo9010.dso;

import org.noear.nami.annotation.NamiClient;

/**
 * @author noear 2024/3/20 created
 */

@NamiClient(name = "demoapp", path = "/api")
public interface Rpc1 {
    boolean list1();
    String list2();
}
