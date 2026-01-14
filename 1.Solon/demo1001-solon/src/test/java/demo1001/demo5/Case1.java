package demo1001.demo5;

import org.noear.solon.annotation.Around;
import org.noear.solon.annotation.Managed;

@Managed
public class Case1 {
    //原始形态（一般不这样使用）
    @Around(LogInterceptor.class)
    public String hello() {
        return "hello";
    }
}
