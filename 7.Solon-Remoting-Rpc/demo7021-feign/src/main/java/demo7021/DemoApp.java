package demo7021;

import org.noear.solon.Solon;
import feign.solon.EnableFeignClient;

@EnableFeignClient
public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class, args);
    }
}
