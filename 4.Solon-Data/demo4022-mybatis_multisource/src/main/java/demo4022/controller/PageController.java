package demo4022.controller;

import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import demo4022.dso.mapper.AppxMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.extend.mybatis.Mybatis;

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
    public Object test() throws Throwable {
        test2();

        SqlPaginations.preparePagination(2, 2);

        return appxMapper.appx_get_page();
    }

    @Mapping("test2")
    public void test2() throws Throwable {
        AppxMapper appxMapper1 = Mybatis.use("db1").getMapper(AppxMapper.class);
        System.out.println(appxMapper1.appx_get());
    }
}
