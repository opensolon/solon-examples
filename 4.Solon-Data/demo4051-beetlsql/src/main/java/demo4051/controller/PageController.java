package demo4051.controller;

import demo4051.dso.mapper.SqlMapper;
import org.beetl.sql.core.page.DefaultPageRequest;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2022/8/19 created
 */
@Mapping("/page/")
@Controller
public class PageController {
    /**
     * 使用SqlMapper默认的数据库注入
     */
    @Db
    SqlMapper sqlMapper;

    @Mapping("/list")
    public Object list() throws Exception {
        PageRequest pageRequest = DefaultPageRequest.of(1, 2);

        return sqlMapper.appx_getlist_page(pageRequest, 1);
    }
}
