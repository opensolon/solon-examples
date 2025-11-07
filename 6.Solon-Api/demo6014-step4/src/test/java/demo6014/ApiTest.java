package demo6014;

import org.junit.jupiter.api.BeforeAll;
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
    private static ONode apiCall(String path) throws IOException {
        String json = new HttpTester().path(path).get();
        return ONode.ofJson(json);
    }

    private static ONode apiCall(String path, String token) throws IOException {
        String json = new HttpTester().path(path).header("token", token).get();
        return ONode.ofJson(json);
    }


    static String token = null;

    @BeforeAll
    public static void api_login() throws IOException {
        token = apiCall("/api/test.login").get("data").getString();
        assert token != null;
        assert token.length() > 10;
        System.out.println("Token: " + token);
    }


    @Test
    public void api_hello() throws IOException {
        assert apiCall("/api/test.hello?name=noear").get("code").getInt() == 4001021;
        assert apiCall("/api/test.hello?name=noear", token).get("code").getInt() == 200;
    }

    @Test
    public void api_error() throws IOException {
        assert apiCall("/api/test.error").get("code").getInt() == 4001021;
        assert apiCall("/api/test.error", token).get("code").getInt() == 400;
    }

    @Test
    public void api_() throws IOException {
        assert apiCall("/api/").get("code").getInt() == 4001011;
        assert apiCall("/api/", token).get("code").getInt() == 4001011;
    }

    @Test
    public void api_2() throws IOException {
        assert apiCall("/api/test.xxx").get("code").getInt() == 4001011;
        assert apiCall("/api/test.xxx/yyy").get("code").getInt() == 4001011;
        assert apiCall("/api/test.xxx", token).get("code").getInt() == 4001011;
        assert apiCall("/api/test.xxx/yyy", token).get("code").getInt() == 4001011;
    }
}
