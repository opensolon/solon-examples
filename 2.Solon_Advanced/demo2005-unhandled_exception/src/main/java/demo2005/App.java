package demo2005;

import org.noear.solon.Solon;
import org.noear.solon.SolonBuilder;

/**
 * @author noear 2022/1/7 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            //手动禁用异常打印
            app.enableErrorAutoprint(false);
        });
    }

    public static void main2(String[] args) {
        Solon.start(App.class, args, app -> {
            app.onError(e -> {
                //订阅异常，会自动禁用异常打印
                e.printStackTrace();
            });
        });
    }

    public static void main3(String[] args) {
        //在 start 之前进行订阅
        new SolonBuilder()
                .onError(e -> {
                    //订阅异常，会自动禁用异常打印
                    e.printStackTrace();
                })
                .start(App.class, args);
    }
}
