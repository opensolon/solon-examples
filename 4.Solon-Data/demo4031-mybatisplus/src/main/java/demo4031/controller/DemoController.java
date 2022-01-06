package demo4031.controller;

import demo4031.dso.mapper.AppxMapper;
import demo4031.model.AppxModel;
import org.apache.ibatis.ext.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Db
    AppxMapper appxMapper;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

}
