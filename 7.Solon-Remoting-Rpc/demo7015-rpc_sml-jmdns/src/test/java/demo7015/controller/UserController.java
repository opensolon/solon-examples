package demo7015.controller;

import demo7015.protocol.UserModel;
import demo7015.protocol.UserService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;


@Controller
public class UserController {
    //使用负载（name 保持与供应服务名相同；path 保持与接口路径相同）
    @NamiClient(name = "demo_rpc",path = "/user")
    UserService userService;

    @Mapping("test")
    public UserModel test() {
        UserModel user = userService.getUser(12);
        System.out.println(user);

        return user;
    }
}