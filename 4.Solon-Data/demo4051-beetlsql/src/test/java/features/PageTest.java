package features;

import org.junit.jupiter.api.Test;

import org.noear.snack4.ONode;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import demo4051.DemoApp;


@SolonTest(DemoApp.class)
public class PageTest extends HttpTester {
    @Test
    public void test() throws Exception {
        String json = path("/page/list").get();
        System.out.println(json);
        assert ONode.ofJson(json).get("list").size() == 2;
    }
}
