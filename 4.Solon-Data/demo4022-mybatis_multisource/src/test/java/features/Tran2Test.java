package features;

import demo4022.DemoApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.Solon;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.wood.DbContext;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class Tran2Test extends HttpTestBase {
    @Test
    public void test() throws Exception {
        DbContext db = Solon.cfg().getBean("test.db1", DbContext.class);
        clear(db);
        path("/tran/test").get();
        path("/tran/test").get();
        path("/tran/test").get();
        assert db.table("test").selectCount() == 6;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
