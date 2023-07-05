package demo1091;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * 程序主入口（启动 Solon 容器）
 * */
@SolonMain
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}