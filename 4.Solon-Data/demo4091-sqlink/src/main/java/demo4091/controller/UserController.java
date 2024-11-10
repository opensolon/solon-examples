package demo4091.controller;

import demo4091.model.User;
import demo4091.service.UserService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

import java.util.List;

@Mapping("/user")
@Controller
public class UserController {

    @Inject
    UserService userService;

    @Mapping("/reg")
    public long reg() {
        String name = "noear";
        String pass = "12345";
        return userService.saveUser(name, pass);
    }

    @Mapping("/change")
    public long change() {
        int id = 1;
        String pass = "54321";
        return userService.changePassById(id, pass);
    }

    @Mapping("/all")
    public List<User> all() {
        return userService.getAll();
    }
}
