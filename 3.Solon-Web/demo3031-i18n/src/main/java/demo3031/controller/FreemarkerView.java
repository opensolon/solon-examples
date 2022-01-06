package demo3031.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

/**
 * 实现简单的 mvc 效果
 * */

@Controller
public class FreemarkerView extends ViewBase {

    @Mapping("/ftl")
    public ModelAndView view() {
        ModelAndView model = new ModelAndView("freemarker.ftl");
        model.put("title", "dock");
        model.put("msg", "你好 world! in XController");

        return model;
    }
}
