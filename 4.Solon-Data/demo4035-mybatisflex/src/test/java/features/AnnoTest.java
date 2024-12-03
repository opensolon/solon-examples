package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;
import demo4035.DemoApp;
import demo4035.dso.mapper.AppxMapper;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class AnnoTest {

    @Inject
    AppxMapper appxMapper;

    @Test
    public void test() {
        assert appxMapper.listTables().size() > 0;
    }
}
