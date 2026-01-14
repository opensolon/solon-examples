package demo1001.demo5_3;

import org.noear.solon.annotation.Managed;

@Managed
public class Case3 {
    //包装形态
    @Log
    public String hello() {
        return "hello";
    }
}
