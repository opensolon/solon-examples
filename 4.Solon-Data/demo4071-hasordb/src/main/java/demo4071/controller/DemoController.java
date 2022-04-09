package demo4071.controller;

import demo4071.dso.mapper.AppxMapper;
import demo4071.model.Appx;
import net.hasor.db.solon.Db;
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
    public Appx test(){
        return appxMapper.appx_get();
    }

}
