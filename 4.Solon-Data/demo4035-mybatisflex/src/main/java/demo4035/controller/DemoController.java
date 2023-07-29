package demo4035.controller;

import demo4035.dso.mapper.AppxMapper;
import demo4035.dso.service.AppServicePlus;
import demo4035.model.AppxModel;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Db
    AppxMapper appxMapper;

    @Inject
    AppServicePlus appServicePlus;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

    @Mapping("test2")
    public AppxModel test2(){
        return appServicePlus.getById(1);
    }

}
