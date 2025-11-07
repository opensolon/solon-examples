package features;

import demo4041.DemoApp;
import org.junit.jupiter.api.Test;

import org.noear.snack4.ONode;
import org.noear.solon.Utils;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;


@SolonTest(DemoApp.class)
public class MapperTest extends HttpTester {
    @Test
    public void test() throws Exception {

        String json = path("/mapper/").get();

        assert Utils.isNotEmpty(json);

        assert  ONode.ofJson(json).isObject();
    }

    @Test
    public void test2() throws Exception {
        String json2 =path("/mapper/test2").get();

        assert Utils.isNotEmpty(json2);

        assert  ONode.ofJson(json2).isObject();
    }
}
