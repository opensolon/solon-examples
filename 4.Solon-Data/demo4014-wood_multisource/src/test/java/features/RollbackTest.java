package features;

import demo4014.DemoApp;
import org.junit.jupiter.api.Test;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.annotation.Rollback;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

@SolonTest(DemoApp.class)
public class RollbackTest extends HttpTester {

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
