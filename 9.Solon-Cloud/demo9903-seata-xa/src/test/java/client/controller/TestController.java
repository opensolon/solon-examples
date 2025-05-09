package client.controller;

import client.dso.DemoService;
import demo9903.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2020/12/28 created
 */
@Controller
public class TestController {

    //这是本地的
    @Inject
    HelloService localService;

    @Inject
    DemoService demoService;

    //这是远程的
    @NamiClient
    HelloService remoteService;

    @Mapping("/insert")
    public String insert(String code) throws Exception {
        try {
            this.demoService.insertData(code);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return code;
    }
}
