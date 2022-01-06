package features;

import org.apache.ibatis.ext.solon.Db;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import demo4021.DemoApp;
import demo4021.dso.mapper.AppxMapper;

/**
 * @author noear 2021/5/16 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class AnnoTest {

    @Db
    AppxMapper appxMapper;

    @Test
    public void test() {
        assert appxMapper.listTables().size() > 0;
    }
}
