package features;

import org.apache.ibatis.solon.annotation.Db;
import org.junit.jupiter.api.Test;


import org.noear.solon.test.SolonTest;
import demo4022.DemoApp;
import demo4022.dso.mapper.AppxMapper;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class AnnoTest {

    @Db
    AppxMapper appxMapper;

    @Test
    public void test() {
        assert appxMapper.appx_get() != null;
    }
}
