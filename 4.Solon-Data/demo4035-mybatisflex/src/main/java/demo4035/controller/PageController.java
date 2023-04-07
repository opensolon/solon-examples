package demo4035.controller;

import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import demo4035.dso.mapper.AppxMapper;
import org.apache.ibatis.solon.annotation.Db;
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
        SqlPaginations.preparePagination(2,2);

       return appxMapper.appx_get_page();

    }
}
