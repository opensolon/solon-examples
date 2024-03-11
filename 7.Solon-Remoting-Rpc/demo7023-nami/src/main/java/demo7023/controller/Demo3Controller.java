package demo7023.controller;

import demo7023.dso.api.RemoteService3;
import demo7023.model.User;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * 注入构建，用服务名
 * */
@Mapping("demo3")
@Controller
public class Demo3Controller {
    @NamiClient(name = "user-service", path = "/users/")
    RemoteService3 service;

    @NamiClient
    RemoteService3 service2;

    @Mapping("test")
    public String test() {
        String result = service.getOwner("scott");

        return result;
    }

    @Mapping("test2")
    public Object test2() {
        User user = service2.get2("scott");

        return user;
    }
}
