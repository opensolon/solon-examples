package features;

import demo3012.WebApp;
import org.junit.jupiter.api.Test;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

@SolonTest(WebApp.class)
public class ServletTest extends HttpTester {
    @Override
    public boolean enablePrint() {
        return true;
    }

    @Test
    public void test1_f_ok() throws Exception{
        assert  path("/hello/").get().equals("OK");
        assert  path("/hello/a").get().equals("OK");
        assert  path("/hello/a/a").get().equals("OK");
    }

    @Test
    public void test1_f_no() throws Exception{
        assert  path("/hello2/").get().equals("OK") == false;
        assert  path("/hello2/a").get().equals("OK") == false;
        assert  path("/hello2/a/a").get().equals("OK") == false;
    }


    @Test
    public void test2_s_ok() throws Exception{
        assert  path("/heihei/").get().equals("OK");
        assert  path("/heihei/a").get().equals("OK");
        assert  path("/heihei/a/a").get().equals("OK");
    }

    @Test
    public void test2_s_no() throws Exception{
        assert  path("/heihe2/").get().equals("OK") == false;
        assert  path("/heihe2/a").get().equals("OK") == false;
        assert  path("/heihe2/a/a").get().equals("OK") == false;
    }
}
