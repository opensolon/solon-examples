package test;

import client.ClientApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author luke 2023/5/18 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(ClientApp.class)
public class ClientTest extends HttpTester {
    @Test
    public void test() throws IOException {
        String rst = path("/test").data("msg", "1").get();

        assert "remote: hello,jdbc".equals(rst);
    }
}
