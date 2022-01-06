package demo3021.controller.strings;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.i18n.annotation.I18n;

//使用指定的国际化内容包
@I18n("i18n.strings")
@Controller
public class VelocityView {

    @Mapping("/velocity")
    public ModelAndView view() {
        ModelAndView model = new ModelAndView("velocity.vm");
        model.put("title", "dock");
        model.put("msg", "你好 world! in XController");

        return model;
    }
}
