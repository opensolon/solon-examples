package demo1011.plugin1.controller;

import demo1011.plugin1.dso.service.AppxService;
import demo1011.plugin1.model.UserDo;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.validation.annotation.NotNull;
import org.noear.solon.validation.annotation.Valid;

@Valid
@Mapping("user")
@Controller
public class UserController extends BaseController {

    @Inject("${user.name}")
    String userName = "111";

    @Inject
    AppxService appxService;

    @Cache
    @Mapping("/get")
    public UserDo get(@NotNull Long userId) {
        System.out.println("get:" + userId);

        UserDo userDo = new UserDo();
        userDo.setUserName("user-" + userId);
        userDo.setUserId(userId);

        return userDo;
    }

    @Mapping("/t")
    public String t() throws Exception {
        Object tmp = appxService.findAppx();

        return userName + "-" + ONode.stringify(tmp);
    }

    @Mapping("/v")
    public ModelAndView v(Context ctx){
       return new ModelAndView("hello.html");
    }

    @Mapping("/v2")
    public ModelAndView v2(Context ctx){
        return new ModelAndView("hello.ftl");
    }
}
