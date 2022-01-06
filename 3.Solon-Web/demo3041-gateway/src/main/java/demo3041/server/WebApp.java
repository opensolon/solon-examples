package demo3041.server;

import org.noear.solon.Solon;

/**
 * @author noear 2021/4/22 created
 */
public class WebApp {
    public static void main(String[] args) {
        Solon.start(WebApp.class, args);

        /**
         * 测试1：运行后可在浏览器打开这两地址，试效果：
         *
         * http://localhost:8080/api/rpc/user/getUser
         * http://localhost:8080/api/rest/user/getUser
         *
         * 测试2：运行后，再启动 ClientApp 看效果
         *
         * */
    }
}
