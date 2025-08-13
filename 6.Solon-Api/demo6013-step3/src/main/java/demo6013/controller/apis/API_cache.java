package demo6013.controller.apis;

import demo6013.controller.ApiBase;
import demo6013.model.AppxModel;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * 有使用缓存的接口
 *
 * @author noear 2021/6/11 created
 */
@Managed(tag = "api")
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
