package demo1011.plugin1.controller;

import demo1011.plugin1.dso.service.AppxService;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;

@Mapping("user")
@Controller
public class UserController extends BaseController {

    @Inject("${user.name}")
    String userName = "111";

    @Inject
    AppxService appxService;

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
