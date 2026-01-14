package demo1001.demo5_2;

import org.noear.solon.annotation.Managed;

@Managed
public class Case2 {
    //包装形态
    @Log
    public String hello() {
        return "hello";
    }
}
