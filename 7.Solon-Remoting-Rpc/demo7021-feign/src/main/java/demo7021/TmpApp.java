package demo7021;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.core.Bridge;
import org.noear.solon.extend.feign.EnableFeignClient;

@EnableFeignClient
public class TmpApp {
    public static void main(String[] args) {
        Solon.start(TmpApp.class, args);
    }
}
