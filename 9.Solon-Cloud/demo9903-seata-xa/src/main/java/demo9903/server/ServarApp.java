package demo9903.server;

import demo9903.support.SysInitUtil;
import org.noear.solon.Solon;

/**
 * @author noear 2021/1/8 created
 */
public class ServarApp {
    public static void main(String[] args) {
        SysInitUtil.init();

        Solon.start(ServarApp.class, args);
    }
}
