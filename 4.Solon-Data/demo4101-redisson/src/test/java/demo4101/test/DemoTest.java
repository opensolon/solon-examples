package demo4101.test;

import demo4101.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.redisson.api.RedissonClient;

/**
 * @author noear 2023/5/28 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(App.class)
public class DemoTest {
    @Inject
    RedissonClient redissonClient;

    @Test
    public void test(){
        redissonClient.getAtomicDouble("test").set(0);
        redissonClient.getAtomicDouble("test").incrementAndGet();
        assert redissonClient.getAtomicDouble("test").get() == 1;
        System.out.println(redissonClient.getAtomicDouble("test").get());
    }
}
