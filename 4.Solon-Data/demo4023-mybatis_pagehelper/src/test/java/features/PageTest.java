package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import demo4023.DemoApp;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class PageTest extends HttpTester {
    @Test
    public void test() throws Exception {
        String json = path("/page/test").get();
        assert ONode.loadStr(json).count() == 2;
    }
}
