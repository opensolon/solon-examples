package demo4071.controller;

import demo4071.dso.mapper.AppxMapper;
import net.hasor.db.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 分面演示（使用sqlhelper组件）
 *
 * */
@Mapping("/page/")
@Controller
public class PageController {
    @Db
    AppxMapper appxMapper;

    @Mapping("test")
    public Object test() throws Throwable{
       return appxMapper.appx_get_page();

    }
}
