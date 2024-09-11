package features;

import org.apache.ibatis.solon.annotation.Db;
import org.junit.jupiter.api.Test;

import org.noear.solon.test.SolonTest;
import demo4021.DemoApp;
import demo4021.dso.mapper.AppxMapper;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class AnnoTest {

    @Db
    AppxMapper appxMapper;

    @Test
    public void test() {
        assert appxMapper.listTables().size() > 0;
    }
}
