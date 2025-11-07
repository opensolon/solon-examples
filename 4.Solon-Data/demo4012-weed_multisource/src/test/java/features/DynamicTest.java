package features;

import demo4012.DemoApp;
import demo4012.model.AppxModel;
import org.noear.snack4.ONode;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

@SolonTest(DemoApp.class)
public class DynamicTest extends HttpTester {


    @Test
    public void test() throws Exception {
        String json1 = path("/dynamic/test1").get();
        String json2 = path("/dynamic/test2").get();
        String json3 = path("/dynamic/test3").get();

        AppxModel app1 = ONode.deserialize(json1, AppxModel.class);
        assert app1.getApp_id() == 1;

        AppxModel app2 = ONode.deserialize(json2, AppxModel.class);
        assert app2.getApp_id() == 2;

        AppxModel app3 = ONode.deserialize(json3, AppxModel.class);
        assert app3.getApp_id() == 3;
    }
}
