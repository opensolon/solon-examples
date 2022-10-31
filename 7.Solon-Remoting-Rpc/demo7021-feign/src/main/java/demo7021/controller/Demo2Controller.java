package demo7021.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import feign.solon.FeignClient;
import demo7021.dso.api.RemoteService2;
import demo7021.model.User;

/**
 * 注入构建，用固定地址
 * */
@Mapping("demo2")
@Controller
public class Demo2Controller {
    @FeignClient(url = "http://127.0.0.1:8080", path = "/users/")
    RemoteService2 service;

    @Inject
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
