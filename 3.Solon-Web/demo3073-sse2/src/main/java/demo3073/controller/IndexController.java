package demo3073.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

@Controller
@Mapping("/")
public class IndexController {

    /**
     * 首页，用于演示如何调用sse。
     *
     * @return
     */
    @Mapping("")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index.ftl");
        return model;
    }
}
