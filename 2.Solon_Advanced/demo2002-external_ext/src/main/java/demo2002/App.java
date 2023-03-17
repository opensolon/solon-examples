package demo2002;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * @author noear 2022/1/7 created
 */
@SolonMain
public class App {
    public static void main(String[] args) {

        Solon.start(App.class, args);

        System.out.println("读取配置 demo_name：" + Solon.cfg().get("demo_name", "1"));
    }
}
