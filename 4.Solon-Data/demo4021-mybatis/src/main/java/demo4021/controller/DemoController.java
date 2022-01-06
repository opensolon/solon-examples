package demo4021.controller;

import demo4021.dso.mapper.AppxMapper;
import demo4021.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Inject
    AppxMapper appxMapper;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

}
