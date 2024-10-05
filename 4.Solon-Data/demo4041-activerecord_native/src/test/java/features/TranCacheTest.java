package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.Solon;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;
import demo4041.DemoApp;

import javax.sql.DataSource;
import java.sql.SQLException;


@SolonTest(DemoApp.class)
public class TranCacheTest extends HttpTester {
    SqlUtils sqlUtils = SqlUtils.of(Solon.context().getBean(DataSource.class));

    private void clear() throws Exception {
        sqlUtils.execute("TRUNCATE TABLE test");
    }

    private long count() throws SQLException {
        return (long) sqlUtils.selectValue("select count(1) from test");
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
