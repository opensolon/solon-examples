package demo1092;

import org.noear.solon.annotation.Component;

/**
 * @author noear 2024/3/25 created
 */
@Component
public class HelloService{
    public String hello(){
        return "Hello word!";
    }
}