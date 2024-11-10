package features;

import demo4091.DemoApp;
import demo4091.model.User;
import demo4091.service.AppService;
import demo4091.service.UserService;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;

import java.util.List;

@SolonTest(DemoApp.class)
public class InterceptTest {
    @Inject
    UserService userService;

    @Test
    public void Intercept1() {
        String name = "noear";
        String pass = "12345";
        userService.saveUser(name, pass);
        List<User> all = userService.getAll();
        User user = all.get(0);
        assert user.getPassword().equals(pass);
        String newPass = "54321";
        userService.changePassById(user.getId(),newPass);
        List<User> all2 = userService.getAll();
        User user2 = all2.get(0);
        assert user2.getPassword().equals(newPass);
    }
}
