package features;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit5Extension;
import org.noear.solon.test.SolonTest;
import demo4031.DemoApp;

@ExtendWith(SolonJUnit5Extension.class)
@SolonTest(DemoApp.class)
public class PageTest extends HttpTester {
    @Test
    public void test() throws Exception {
        String json = path("/page/test").get();
        assert ONode.loadStr(json).get("records").count() == 2;
    }
}
