package test;

import client.ClientApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2021/1/18 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(ClientApp.class)
public class ClientTest extends HttpTestBase {
    @Test
    public void test() throws IOException {
        String rst = path("/test").data("msg", "1").get();

        assert "remote: hello,jdbc".equals(rst);
    }
}
