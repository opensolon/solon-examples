package demo6013;

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
        assert apiCall("/api/hello?name=noear").get("code").getInt() == 4001021;
        assert apiCall("/api/hello?name=noear&t=1").get("code").getInt() == 200;
    }

    @Test
    public void api_error() throws IOException {
        assert apiCall("/api/error").get("code").getInt() == 4001021;
        assert apiCall("/api/error?t=1").get("code").getInt() == 400;
    }

    @Test
    public void api_() throws IOException {
        assert apiCall("/api/").get("code").getInt() == 4001011;
        assert apiCall("/api/?t=1").get("code").getInt() == 4001011;
    }

    @Test
    public void api_2() throws IOException {
        assert apiCall("/api/xxx").get("code").getInt() == 4001011;
        assert apiCall("/api/xxx/yyy").get("code").getInt() == 4001011;
        assert apiCall("/api/xxx?t=1").get("code").getInt() == 4001011;
        assert apiCall("/api/xxx/yyy?t=1").get("code").getInt() == 4001011;
    }
}
