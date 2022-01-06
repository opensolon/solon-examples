package demo1001.demo4_2;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Import;

/**
 * 通过导入器扩充扫描包的范围。注解模式
 * @author noear 2021/12/28 created
 */

//如果 UserServiceImpl 是在 org.example.demo2 包下，又想被扫描
//@Import(UserServiceImpl.class)

//此时会增加 org.example.demo2 包的扫描
@Import(scanPackages = "org.example.demo2")
public class App{
    public static void main(String[] args){
        Solon.start(App.class, args);
    }
}