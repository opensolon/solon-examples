package demo6011;

import org.junit.jupiter.api.Test;

import org.noear.snack4.ONode;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2021/6/11 created
 */

@SolonTest(ApiApp.class)
public class ApiTest extends HttpTester {
    private ONode apiCall(String path) throws IOException {
        String json = path(path).get();
        return ONode.ofJson(json);
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
