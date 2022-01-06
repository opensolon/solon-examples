package demo1001.demo4;

import org.noear.solon.Solon;

/**
 * 启动时扫描
 *
 * @author noear 2021/12/28 created
 */
public class App {
    public static void main(String[] args){
        //
        // App.clas 的作用，是提供一个扫描范围；App.class 所在包名下的bean都会被扫描到
        //
        Solon.start(App.class, args);
    }
}
