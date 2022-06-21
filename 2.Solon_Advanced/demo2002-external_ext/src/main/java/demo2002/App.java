package demo2002;

import org.noear.solon.Solon;
import org.noear.solon.web.staticfiles.StaticMappings;
import org.noear.solon.web.staticfiles.repository.ExtendStaticRepository;

/**
 * @author noear 2022/1/7 created
 */
public class App {
    public static void main(String[] args) {

        Solon.start(App.class, args, app -> {
            StaticMappings.add("/", new ExtendStaticRepository());
        });

        System.out.println("读取配置 demo_name：" + Solon.cfg().get("demo_name", "1"));
    }
}
