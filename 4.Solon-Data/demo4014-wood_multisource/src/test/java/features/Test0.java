package features;

import demo4014.DemoApp;
import demo4014.dso.mapper.SqlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.wood.annotation.Db;

import java.util.Set;

/**
 * @author noear 2021/2/3 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class Test0 {
    @Db
    SqlMapper sqlMapper;

    @Test
    public void test0() throws Exception{
        Integer tmp = sqlMapper.appx_get0();
        assert  tmp == null;

        assert  sqlMapper.appx_get() > 0;
    }

    @Test
    public void test1() throws Exception{
        Set<Integer> sets = sqlMapper.appx_getids2();

        System.out.println(sets);

        assert sets.size() == 4;
    }
}
