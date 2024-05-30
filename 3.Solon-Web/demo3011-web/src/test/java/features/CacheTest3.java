package features;

import demo3011.WebApp;
import org.junit.jupiter.api.Test;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

@SolonTest(WebApp.class)
public class CacheTest3 extends HttpTester {
    @Test
    public void test1() throws Exception{
        String rst = path("/cache3/").get();

        Thread.sleep(100);

        assert rst.equals(path("/cache3/").get());

        Thread.sleep(100);

        assert rst.equals(path("/cache3/").get());

        Thread.sleep(100);

        assert rst.equals(path("/cache3/").get());
    }

    @Test
    public void test2() throws Exception{
        String rst = path("/cache3/").get();

        Thread.sleep(100);
        assert rst.equals(path("/cache3/").get());

        rst = path("/cache3/update").get();
        assert rst.equals(path("/cache3/").get());

    }
}
