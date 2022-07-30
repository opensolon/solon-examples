package demo3036.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

/**
 * @author noear 2021/6/12 created
 */
@Controller
public class DemoController {
    @Mapping("/")
    public Object test(){
        ModelAndView model = new ModelAndView("enjoy.shtm");
        model.put("title","dock");
        model.put("message","你好 world!");

        return model;
    }
}
