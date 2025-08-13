package demo4031.dso.service;

import demo4031.model.AppxModel;
import org.noear.solon.annotation.Managed;

/**
 * @author noear 2022/4/26 created
 */
@Managed
public class TestService extends TestServiceBase {
    public AppxModel getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }
}
