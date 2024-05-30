package features;

import demo4003.App;
import demo4003.model.AppxModel;
import org.junit.jupiter.api.Test;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

@SolonTest(App.class)
public class DemoTest extends HttpTester {

    @Test
    public void test() throws Exception {
        String json1 = path("/demo/test1").get();

        AppxModel app1 = ONode.deserialize(json1, AppxModel.class);
        assert app1.getApp_id() == 1;
    }
}
