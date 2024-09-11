package features;

import demo4022.DemoApp;
import org.junit.jupiter.api.Test;

import org.noear.solon.Solon;
import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;
import org.noear.wood.DbContext;


@SolonTest(DemoApp.class)
public class Tran2Test extends HttpTester {
    @Test
    public void test() throws Exception {
        DbContext db = Solon.cfg().toBean("test.db1", DbContext.class);
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
