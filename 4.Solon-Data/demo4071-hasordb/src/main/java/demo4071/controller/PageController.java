package demo4071.controller;

import demo4071.dso.mapper.AppxMapper;
import net.hasor.db.page.Page;
import net.hasor.db.page.PageObject;
import net.hasor.db.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 分面演示
 *
 * */
@Mapping("/page/")
@Controller
public class PageController {
    @Db
    AppxMapper appxMapper;

    @Mapping("test")
    public Object test() throws Throwable{
        Page page =new PageObject();
        page.setCurrentPage(2);
        page.setPageSize(2);

       return appxMapper.appx_get_page(page);
    }
}
