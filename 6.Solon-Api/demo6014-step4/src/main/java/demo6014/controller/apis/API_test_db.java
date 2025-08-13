package demo6014.controller.apis;

import demo6014.controller.ApiBase;
import demo6014.dso.service.AppxService;
import demo6014.model.AppxModel;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.validation.annotation.Logined;
import org.noear.solon.validation.annotation.NotZero;
import org.noear.solon.validation.annotation.Validated;

import java.sql.SQLException;

/**
 * 有操作数据库的接口
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
public class API_test_db extends ApiBase {

    @Inject
    AppxService appxService;

    @Logined //登录用户才可用
    @NotZero("appId")
    @Mapping("test.db")
    public AppxModel exec(int appId) throws SQLException {
        return appxService.getAppx(appId);
    }


    /**
     * 添加实体验证示例
     * */
    @Mapping("db2")
    public AppxModel db2(@Validated AppxModel app) throws SQLException {
        return app;
    }
}
