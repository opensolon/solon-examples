package demo9a03;

import org.noear.solon.Solon;

public class App2 {
    public static void main(String[] args) {
        //指定配置，避免影响测试
        Solon.start(App2.class, new String[]{"--server.port=8081"});
    }
}