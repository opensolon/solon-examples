package demo4031.controller;

import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import demo4031.dso.mapper.AppxMapper;
import demo4031.model.AppxModel;
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
    public Object test() throws Throwable {
        Page<AppxModel> page = new Page<>(2, 3);

        return appxMapper.appx_get_page(page);
    }
}
