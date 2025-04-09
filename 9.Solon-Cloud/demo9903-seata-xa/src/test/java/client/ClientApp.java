package client;

import org.noear.solon.Solon;

/**
 * @author noear 2020/12/28 created
 */
public class ClientApp {
    public static void main(String[] args) {
        // SysInitUtil.init();

        Solon.start(ClientApp.class, args);
    }
}
