package demo4003.controller;

import demo4003.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

/**
 * @author noear 2022/11/23 created
 */
@Mapping("/demo/")
@Controller
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Db
    DbContext db;

    @Mapping("/test1")
    public AppxModel test1() throws Exception{
        return db.table("appx")
                .whereEq("app_id",1)
                .selectItem("*",AppxModel.class);
    }
}
