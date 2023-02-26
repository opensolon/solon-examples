package demo4031.dso.service;

import demo4031.model.AppxModel;
import org.noear.solon.proxy.annotation.ProxyComponent;

/**
 * @author noear 2022/4/26 created
 */
@ProxyComponent
public class TestService extends TestServiceBase {
    public AppxModel getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }
}
