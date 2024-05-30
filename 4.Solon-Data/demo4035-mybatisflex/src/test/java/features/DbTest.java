package features;

import com.mybatisflex.core.row.Db;
import com.mybatisflex.core.row.Row;
import demo4035.DemoApp;
import org.junit.jupiter.api.Test;


import org.noear.solon.test.SolonTest;

/**
 * @author noear 2023/4/24 created
 */

@SolonTest(DemoApp.class)
public class DbTest {
    @Test
    public void test() {
        Row row = Db.selectOneById("appx", "app_id", 1);
        assert row != null;
    }
}
