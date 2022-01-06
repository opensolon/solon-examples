package demo4023.controller;

import com.github.pagehelper.PageHelper;
import demo4023.dso.mapper.AppxMapper;
import org.apache.ibatis.ext.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 分面演示（使用 PageHelper 组件）
 *
 * */
@Mapping("/page/")
@Controller
public class PageController {
    @Db
    AppxMapper appxMapper;

    @Mapping("test")
    public Object test() throws Throwable {
        PageHelper.offsetPage(2, 2);
        return appxMapper.appx_get_page();
    }
}
