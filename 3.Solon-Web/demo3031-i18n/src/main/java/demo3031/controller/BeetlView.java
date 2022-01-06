package demo3031.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

@Controller
public class BeetlView extends ViewBase{
    @Mapping("/beetl")
    public ModelAndView view(){
        ModelAndView model = new ModelAndView("beetl.htm");
        model.put("title","dock");
        model.put("msg","你好 world! in XController");

        return model;
    }
}
