package demo7002.client.controller;

import demo7002.protocol.UserModel;
import demo7002.protocol.UserService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2022/1/6 created
 */
@Controller
public class UserController {
    //使用负载
    @NamiClient(name = "local",path = "/user/")
    UserService userService;

    @Mapping("test")
    public UserModel test() {
        UserModel user = userService.getUser(12);
        System.out.println(user);

        return user;
    }
}
