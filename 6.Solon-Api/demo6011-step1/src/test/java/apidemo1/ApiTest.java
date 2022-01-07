package apidemo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.snack.ONode;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2021/6/11 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(App.class)
public class ApiTest extends HttpTestBase {
    private ONode apiCall(String path) throws IOException {
        String json = path(path).get();
        return ONode.loadStr(json);
    }

    @Test
    public void api_hello() throws IOException {
        assert apiCall("/api/hello?name=noear").get("code").getInt() == 200;
    }

    @Test
    public void api_() throws IOException {
        assert apiCall("/api/").get("code").getInt() == 404;
    }

    @Test
    public void api_2() throws IOException {
        assert apiCall("/api/xxx").get("code").getInt() == 404;
        assert apiCall("/api/xxx/yyy").get("code").getInt() == 404;
    }
}
