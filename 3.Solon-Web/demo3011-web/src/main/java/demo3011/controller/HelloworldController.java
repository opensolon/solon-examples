package demo3011.controller;

import demo3011.model.UserModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.i18n.annotation.I18n;

@I18n
@Controller
public class HelloworldController {
    @Mapping("/helloworld")
    public Object helloworld(){
        UserModel m = new UserModel();
        m.setId(10);
        m.setName("刘之西东");
        m.setSex(1);

        ModelAndView vm = new ModelAndView("helloworld.ftl");

        vm.put("title","demo");
        vm.put("message","hello world!");
        vm.put("m",m);

        return vm;
    }
}
