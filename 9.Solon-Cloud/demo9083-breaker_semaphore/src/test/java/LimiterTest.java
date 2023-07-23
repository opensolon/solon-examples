import demo9083.DemoApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.Utils;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author noear 2021/5/6 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class LimiterTest extends HttpTester {
    @Test
    public void test() throws Exception{
        CountDownLatch  count = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            Utils.async(()->{
                try{
                    path("/").get();
                }catch (Exception e){
                    e.printStackTrace();
                }

                count.countDown();
            });
        }

        count.await();
    }
}
