package demo3014.controller;

import demo3014.model.UserModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;

@Controller
public class HelloworldController {

    @Inject("${custom.user}")
    protected String user;

    @Mapping("/helloworld")
    public Object helloworld(Context ctx){
        UserModel m = new UserModel();
        m.setId(10);
        m.setName("刘之西东");
        m.setSex(1);

        ModelAndView vm = new ModelAndView("helloworld.jsp");

        vm.put("title","demo");
        vm.put("message","hello world!");

        vm.put("m",m);

        vm.put("user", user);

        vm.put("ctx",ctx);

        return vm;
    }
}
