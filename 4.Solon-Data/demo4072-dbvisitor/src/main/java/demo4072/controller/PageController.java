package demo4072.controller;

import demo4072.dso.mapper.AppxMapper;
import net.hasor.dbvisitor.page.Page;
import net.hasor.dbvisitor.page.PageObject;
import net.hasor.dbvisitor.solon.Db;
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
