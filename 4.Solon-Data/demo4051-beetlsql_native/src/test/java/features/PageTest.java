package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import demo4051.DemoApp;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class PageTest extends HttpTestBase {
    @Test
    public void test() throws Exception {
        String json = path("/page/list").get();
        assert ONode.loadStr(json).get("list").count() == 2;
    }
}
