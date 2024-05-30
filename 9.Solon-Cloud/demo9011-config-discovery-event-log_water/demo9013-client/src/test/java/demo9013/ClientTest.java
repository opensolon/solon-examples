package demo9013;

import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2021/1/18 created
 */

@SolonTest(ClientApp.class)
public class ClientTest extends HttpTester {
    @Test
    public void test() throws IOException {
        String rst = path("/test").data("msg", "1").get();

        assert "remote: hello,jdbc".equals(rst);
    }
}
