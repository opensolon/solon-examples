package demo4033.controller;

import demo4033.dso.mapper.AppxMapper;
import demo4033.dso.service.AppServicePlus;
import demo4033.model.AppxModel;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

@Mapping("/demo/")
@Controller
public class DemoController {

    @Db
    AppServicePlus appService;

    @Mapping("test")
    public Object test(){
        return appService.getMap(null);
    }

}
