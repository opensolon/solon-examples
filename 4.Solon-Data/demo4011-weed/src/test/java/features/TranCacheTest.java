package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;
import demo4011.DemoApp;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class TranCacheTest extends HttpTester {
    @Db
    DbContext db;

    @Test
    public void test0() throws Exception {
        clear(db);
        path("/tran/test0").get();
        path("/tran/test0").get();
        path("/tran/test0").get();
        assert db.table("test").selectCount() == 2;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
