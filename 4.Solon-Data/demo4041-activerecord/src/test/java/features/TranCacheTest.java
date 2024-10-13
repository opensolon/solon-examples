package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;
import demo4041.DemoApp;

import javax.sql.DataSource;
import java.sql.SQLException;


@SolonTest(DemoApp.class)
public class TranCacheTest extends HttpTester {
    @Inject
    SqlUtils sqlUtils;

    private void clear() throws Exception {
        sqlUtils.sql("TRUNCATE TABLE test").update();
    }

    private long count() throws SQLException {
        return sqlUtils.sql("select count(1) from test").queryValue();
    }

    @Test
    public void test0() throws Exception {
        clear();
        path("/tran/test0").get();
        path("/tran/test0").get();
        path("/tran/test0").get();
        assert count() == 2;
    }
}
