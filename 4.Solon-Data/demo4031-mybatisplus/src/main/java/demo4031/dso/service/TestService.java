package demo4031.dso.service;

import demo4031.model.AppxModel;
import org.noear.solon.aspect.annotation.Service;

/**
 * @author noear 2022/4/26 created
 */
@Service
public class TestService extends TestServiceBase {
    public AppxModel getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }
}
