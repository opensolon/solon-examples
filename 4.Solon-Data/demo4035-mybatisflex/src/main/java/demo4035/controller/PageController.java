package demo4035.controller;

import com.github.pagehelper.PageHelper;
import demo4035.dso.mapper.AppxMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * 分面演示（使用sqlhelper组件）
 *
 * */
@Mapping("/page/")
@Controller
public class PageController {
    @Inject
    AppxMapper appxMapper;

    @Mapping("test")
    public Object test() throws Throwable{
        PageHelper.offsetPage(2, 2);

       return appxMapper.appx_get_page();

    }

}
