package demo4013.controller;

import demo4013.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

/**
 * 分页演示
 *
 * */
@Mapping("/page/")
@Controller
public class PageController {
    @Db
    DbContext db;

    @Mapping("test")
    public Object test() throws Throwable {
        //只有 .table 接口和 .mapperBase 接口，有便捷分页功能
        return db.table("appx")
                .limit(0, 2)
                .selectPage("*", AppxModel.class);
    }
}
