package features;

import demo4011.DemoApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.data.annotation.Rollback;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class RollbackTest extends HttpTestBase {

    @Db
    DbContext db;

    @Rollback
    @Test
    public void test1() throws Exception {
        clear(db);

        db.table("test").set("v1", "1111").insert();
        db.table("test").set("v1", "1111").insert();
        db.table("test").set("v1", "1111").insert();

        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test2() throws Exception {
        assert db.table("test").selectCount() == 0;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
