package features;

import demo4061.DemoApp;
import org.junit.jupiter.api.Test;

import org.noear.snack4.ONode;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;

/**
 * @author noear 2023/9/8 created
 */

@SolonTest(DemoApp.class)
public class UserTest extends HttpTester {
    @Test
    public void test1() throws Exception {
        String json = path("/user/list").get();
        ONode oNode = ONode.ofJson(json);

        assert oNode.get("pageSize").getInt() == 10;
        assert oNode.get("recordCount").getInt() == 2;
    }
}
