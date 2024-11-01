package demo4091.controller;

import demo4091.model.AppxModel;
import demo4091.service.AppService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

@Mapping("/demo/")
@Controller
public class DemoController {

    @Inject
    AppService appService;

    @Mapping("test")
    public AppxModel test(){
        return appService.getOne();
    }

    @Mapping("test2")
    public AppxModel test2(){
        return appService.getOneById(1);
    }
}
