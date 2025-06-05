package demo7003.test;

import demo7003.client.WebApp;
import org.junit.jupiter.api.Test;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2025/6/5 created
 */
@SolonTest(WebApp.class)
public class HelloTest extends HttpTester {
    @Test
    public void hello() throws Exception {
        String user = path("/test").get();
        assert user != null;
    }
}
