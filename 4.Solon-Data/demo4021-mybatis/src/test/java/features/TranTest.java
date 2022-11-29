package features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.Solon;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.weed.DbContext;
import demo4021.DemoApp;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class TranTest extends HttpTestBase {
    DbContext db = Solon.cfg().getBean("test.db1", DbContext.class);

    @Test
    public void test() throws Exception {
        clear(db);
        path("/tran/test").get();
        path("/tran/test").get();
        path("/tran/test").get();
        assert db.table("test").selectCount() == 6;
    }

    @Test
    public void test2() throws Exception {
        clear(db);
        path("/tran/test2").get();
        path("/tran/test2").get();
        path("/tran/test2").get();
        assert db.table("test").selectCount() == 0;
    }

    @Test
    public void test11() throws Exception {
        clear(db);
        path("/tran/test11").get();
        path("/tran/test11").get();
        path("/tran/test11").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test12() throws Exception {
        clear(db);
        path("/tran/test12").get();
        path("/tran/test12").get();
        path("/tran/test12").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test21() throws Exception {
        clear(db);
        path("/tran/test21").get();
        path("/tran/test21").get();
        path("/tran/test21").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test22() throws Exception {
        clear(db);
        path("/tran/test22").get();
        path("/tran/test22").get();
        path("/tran/test22").get();
        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }


    @Test
    public void test41() throws Exception {
        clear(db);
        path("/tran/test41").get();
        path("/tran/test41").get();
        path("/tran/test41").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test51() throws Exception {
        clear(db);
        path("/tran/test51").get();
        path("/tran/test51").get();
        path("/tran/test51").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test61() throws Exception {
        clear(db);
        path("/tran/test61").get();
        path("/tran/test61").get();
        path("/tran/test61").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test63() throws Exception {
        clear(db);
        path("/tran/test63").get();
        path("/tran/test63").get();
        path("/tran/test63").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test71() throws Exception {
        clear(db);
        path("/tran/test71").get();
        path("/tran/test71").get();
        path("/tran/test71").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test73() throws Exception {
        clear(db);
        path("/tran/test73").get();
        path("/tran/test73").get();
        path("/tran/test73").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
