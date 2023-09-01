package features;

import demo4002.DemoApp;
import demo4002.dso.DynamicService;
import demo4002.model.AppxModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class DynamicTest extends HttpTester {

    @Inject
    DynamicService dynamicService;

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

    @Test
    public void test1() throws Exception{
        assert  "db_rock1".equals(dynamicService.test1());
        assert  "db_rock2".equals(dynamicService.test2());
        assert  "".equals(dynamicService.test3());
    }
}
