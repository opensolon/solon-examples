package demo1092;

import org.noear.solon.annotation.Managed;

/**
 * @author noear 2024/3/25 created
 */
@Managed
public class HelloService{
    public String hello(){
        return "Hello word!";
    }
}