package demo1001.demo5_3;

import org.noear.solon.Solon;

public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            //在应用启动时；或者插件启动时；注册拦截器
            app.context().beanInterceptorAdd(Log.class, new LogInterceptor());
        });
    }
}
