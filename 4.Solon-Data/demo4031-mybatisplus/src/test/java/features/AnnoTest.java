package features;

import org.apache.ibatis.solon.annotation.Db;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.noear.solon.test.SolonJUnit5Extension;
import org.noear.solon.test.SolonTest;
import demo4031.DemoApp;
import demo4031.dso.mapper.AppxMapper;

/**
 * @author noear 2021/5/16 created
 */
@ExtendWith(SolonJUnit5Extension.class)
@SolonTest(DemoApp.class)
public class AnnoTest {

    @Db
    AppxMapper appxMapper;

    @Test
    public void test() {
        assert appxMapper.listTables().size() > 0;
    }
}
