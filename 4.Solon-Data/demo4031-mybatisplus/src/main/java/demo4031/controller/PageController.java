package demo4031.controller;

import com.github.pagehelper.PageHelper;
import demo4031.dso.mapper.AppxMapper;
import org.apache.ibatis.ext.solon.Db;
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
        PageHelper.offsetPage(2, 2);

       return appxMapper.appx_get_page();

    }
}
