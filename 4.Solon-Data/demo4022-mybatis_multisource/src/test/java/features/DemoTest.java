package features;

import org.junit.jupiter.api.Test;

import org.noear.snack.ONode;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;
import demo4022.DemoApp;

/**
 * @author noear 2021/9/27 created
 */

@SolonTest(DemoApp.class)
public class DemoTest extends HttpTester {
    @Test
    public void test() throws Exception {
        String json = path("/demo/test").get();
        assert ONode.loadStr(json).count() > 2;
    }

    @Test
    public void test2() throws Exception {
        String json = path("/demo/test2").get();
        assert ONode.loadStr(json).count() > 2;
    }
}
