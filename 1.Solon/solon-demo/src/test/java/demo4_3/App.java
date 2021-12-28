package demo4_3;

import org.noear.solon.Solon;

/**
 * 手动模式
 *
 * @author noear 2021/12/28 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {

            //此时会增加 org.example.demo2 包的扫描（手动模式，在开发插件时会带来便利）
            app.beanScan("org.example.demo2");


            //相对来说，只导入一个类性能要好很多（随需而定）
            //app.beanMake(UserServiceImpl.class);
        });
    }
}
