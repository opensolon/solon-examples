package apidemo3.controller.apis;

import apidemo3.controller.ApiBase;
import apidemo3.model.AppxModel;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * 有使用缓存的接口
 *
 * @author noear 2021/6/11 created
 */
@Component(tag = "api")
public class API_cache extends ApiBase {
    @Cache(seconds = 12)
    @Mapping("cache")
    public List exec() {
       List<AppxModel> list = new ArrayList<>();

        AppxModel app = new AppxModel();
        app.setApp_id(1001);

       list.add(app);

       return list;
    }
}
