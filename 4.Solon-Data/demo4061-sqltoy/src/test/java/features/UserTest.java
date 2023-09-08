package features;

import demo4061.DemoApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2023/9/8 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class UserTest extends HttpTester {
    @Test
    public void test1() throws Exception {
        String json = path("/user/list").get();
        ONode oNode = ONode.load(json);

        assert oNode.get("pageSize").getInt() == 10;
        assert oNode.get("recordCount").getInt() == 2;
    }
}
