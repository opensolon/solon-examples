package demo4051.controller;

import demo4051.dso.mapper.SqlMapper;
import demo4051.model.AppxModel;
import org.beetl.sql.core.page.DefaultPageRequest;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
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
    public PageResult<AppxModel> list() throws Exception {
        PageRequest pageRequest = DefaultPageRequest.of(1, 2);

        return sqlMapper.appx_getlist_page(pageRequest, 1);
    }
}
