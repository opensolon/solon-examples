package features.demo9a03;

import labs.demo9a03.GatewayApp;
import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

@SolonTest(GatewayApp.class)
public class HelloTest extends HttpTester {
    @Test
    public void hello() throws IOException {
        assert path("/demo-app/hello?name=world").get().contains("world");
        assert path("/demo-app/hello?name=solon").get().contains("solon");
    }
}