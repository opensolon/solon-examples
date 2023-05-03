package features;

import demo4041.DemoApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.Utils;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class MapperTest extends HttpTestBase {


    @Test
    public void test() throws Exception {

        String json = path("/mapper/").get();

        assert Utils.isNotEmpty(json);

        assert  ONode.load(json).isObject();
    }

    @Test
    public void test2() throws Exception {
        String json2 =path("/mapper/test2").get();

        assert Utils.isNotEmpty(json2);

        assert  ONode.load(json2).isObject();
    }
}
