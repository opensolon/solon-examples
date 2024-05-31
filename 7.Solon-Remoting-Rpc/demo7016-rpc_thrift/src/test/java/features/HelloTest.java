package features;

import com.example.demo.DemoApp;

import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;

import java.io.IOException;


@SolonTest(DemoApp.class)
public class HelloTest extends HttpTester {
    @Test
    public void hello() throws IOException {
        assert path("/hello?name=world").get().contains("world");
        assert path("/hello?name=solon").get().contains("solon");
    }

    @Test
    public void test() throws IOException {
        assert path("/test").get().contains("1");
    }

    @Test
    public void test2() throws IOException {
        assert path("/test2").get().contains("1");
    }
}