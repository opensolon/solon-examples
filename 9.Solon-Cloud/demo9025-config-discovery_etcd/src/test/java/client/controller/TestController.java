package client.controller;

import demo9025.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.annotation.CloudConfig;

/**
 * @author luke
 */
@Controller
public class TestController {
    //注：非单例，不需要加autoRefreshed
    @CloudConfig(value = "water_cache_header", autoRefreshed = true)
    String water_cache_header;

    //这是本地的
    @Inject
    HelloService helloService;

    //这是远程的
    @NamiClient
    HelloService helloService2;

    @Mapping("/test")
    public String home(String msg) throws Exception {
        System.out.println(water_cache_header);

        helloService.hello();
        String temp = helloService2.hello();

        return temp + "," + Solon.cfg().get("db1.url");
    }


}
