package demo6014.dso.service;

import demo6014.model.AppxModel;
import org.noear.solon.annotation.Managed;
import org.noear.solon.data.annotation.Cache;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

import java.sql.SQLException;

/**
 * @author noear 2021/6/11 created
 */
@Managed
public class AppxService {

    //Db 是 wood 的注解；可将数据源注入为 wood 上下文，或者 Mapper
    @Db
    DbContext db;

    @Cache(seconds = 12)
    public AppxModel getAppx(int app_id) throws SQLException {
        //
        //随便写个示例
        //
        return db.table("appx")
                .whereEq("app_id", app_id)
                .limit(1)
                .selectItem("*", AppxModel.class);
    }
}
