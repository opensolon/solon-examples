package demo4021.controller;

import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import demo4021.dso.mapper.AppxMapper;
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
        SqlPaginations.preparePagination(2,2);

       return appxMapper.appx_get_page();

    }
}
