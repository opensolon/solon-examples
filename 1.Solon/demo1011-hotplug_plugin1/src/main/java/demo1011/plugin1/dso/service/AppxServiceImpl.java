package demo1011.plugin1.dso.service;

import org.noear.solon.proxy.annotation.ProxyComponent;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

import java.sql.SQLException;
import java.util.List;

/**
 * @author noear 2022/10/29 created
 */
@ProxyComponent
public class AppxServiceImpl implements AppxService {
    @Db
    DbContext db;

    @Override
    public List findAppx() throws SQLException {
        return db.table("appx")
                .limit(2)
                .selectMapList("*");
    }
}
