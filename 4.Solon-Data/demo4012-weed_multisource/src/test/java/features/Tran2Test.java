package features;

import demo4012.DemoApp;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

@SolonTest(DemoApp.class)
public class Tran2Test extends HttpTester {

    @Db
    DbContext db;

    @Test
    public void test() throws Exception {
        clear(db);
        path("/tran2/test").get();
        path("/tran2/test").get();
        path("/tran2/test").get();
        assert db.table("test").selectCount() == 6;
    }

    @Test
    public void test2() throws Exception {
        clear(db);
        path("/tran2/test2").get();
        path("/tran2/test2").get();
        path("/tran2/test2").get();
        assert db.table("test").selectCount() == 0;
    }

    @Test
    public void test11() throws Exception {
        clear(db);
        path("/tran2/test11").get();
        path("/tran2/test11").get();
        path("/tran2/test11").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test12() throws Exception {
        clear(db);
        path("/tran2/test12").get();
        path("/tran2/test12").get();
        path("/tran2/test12").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test12_2() throws Exception {
        clear(db);
        path("/tran2/test12_2").get();
        path("/tran2/test12_2").get();
        path("/tran2/test12_2").get();
        assert db.table("test").selectCount() == 0;
    }

    @Test
    public void test21() throws Exception {
        clear(db);
        path("/tran2/test21").get();
        path("/tran2/test21").get();
        path("/tran2/test21").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test22() throws Exception {
        clear(db);
        path("/tran2/test22").get();
        path("/tran2/test22").get();
        path("/tran2/test22").get();
        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }


    @Test
    public void test41() throws Exception {
        clear(db);
        path("/tran2/test41").get();
        path("/tran2/test41").get();
        path("/tran2/test41").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test41_2() throws Exception {
        clear(db);
        path("/tran2/test41?nt=1").get();
        path("/tran2/test41?nt=1").get();
        path("/tran2/test41?nt=1").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }


    @Test
    public void test42() throws Exception {
        clear(db);
        path("/tran2/test42").get();
        path("/tran2/test42").get();
        path("/tran2/test42").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test42_2() throws Exception {
        clear(db);
        path("/tran2/test42?nt=1").get();
        path("/tran2/test42?nt=1").get();
        path("/tran2/test42?nt=1").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }


    @Test
    public void test51() throws Exception {
        clear(db);
        path("/tran2/test51").get();
        path("/tran2/test51").get();
        path("/tran2/test51").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test52() throws Exception {
        clear(db);
        path("/tran2/test52").get();
        path("/tran2/test52").get();
        path("/tran2/test52").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 1; //因为有cache，只被执行了1次
    }

    @Test
    public void test61() throws Exception {
        clear(db);
        path("/tran2/test61").get();
        path("/tran2/test61").get();
        path("/tran2/test61").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test63() throws Exception {
        clear(db);
        path("/tran2/test63").get();
        path("/tran2/test63").get();
        path("/tran2/test63").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test71() throws Exception {
        clear(db);
        path("/tran2/test71").get();
        path("/tran2/test71").get();
        path("/tran2/test71").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test71_2() throws Exception {
        clear(db);
        path("/tran2/test71_2").get();
        path("/tran2/test71_2").get();
        path("/tran2/test71_2").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test73() throws Exception {
        clear(db);
        path("/tran2/test73").get();
        path("/tran2/test73").get();
        path("/tran2/test73").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test74() throws Exception {
        clear(db);
        path("/tran2/test74").get();
        path("/tran2/test74").get();
        path("/tran2/test74").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test74_2() throws Exception {
        clear(db);
        path("/tran2/test74_2").get();
        path("/tran2/test74_2").get();
        path("/tran2/test74_2").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test75() throws Exception {
        clear(db);
        path("/tran2/test75").get();
        path("/tran2/test75").get();
        path("/tran2/test75").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 1;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
