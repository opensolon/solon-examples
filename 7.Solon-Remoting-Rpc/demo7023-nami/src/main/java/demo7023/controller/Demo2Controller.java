package demo7023.controller;

import demo7023.dso.api.RemoteService2;
import demo7023.model.User;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * 注入构建，用固定地址
 * */
@Mapping("demo2")
@Controller
public class Demo2Controller {
    @NamiClient(url = "http://127.0.0.1:8080/users/")
    RemoteService2 service;

    @NamiClient
    RemoteService2 service2;

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
