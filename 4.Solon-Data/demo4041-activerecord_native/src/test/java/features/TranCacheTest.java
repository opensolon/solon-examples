package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;
import demo4041.DemoApp;


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
