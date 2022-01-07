package apidemo4.controller.apis;

import apidemo4.controller.ApiBase;
import apidemo4.model.AppxModel;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.validation.annotation.Logined;

import java.util.ArrayList;
import java.util.List;

/**
 * 有使用缓存的接口
 *
 * @author noear 2021/6/11 created
 */
@Component(tag = "api")
public class API_test_cache extends ApiBase {

    @Logined //登录用户才可用
    @Cache(seconds = 12) //缓存12秒
    @Mapping("test.cache")
    public List exec() {
       List<AppxModel> list = new ArrayList<>();

        AppxModel app = new AppxModel();
        app.setApp_id(1001);

       list.add(app);

       return list;
    }
}
