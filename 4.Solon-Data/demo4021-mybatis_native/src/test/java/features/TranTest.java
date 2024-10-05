package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.Solon;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import demo4021.DemoApp;

import javax.sql.DataSource;
import java.sql.SQLException;


@SolonTest(DemoApp.class)
public class TranTest extends HttpTester {
    SqlUtils sqlUtils = SqlUtils.of(Solon.context().getBean(DataSource.class));

    private void clear() throws Exception {
        sqlUtils.execute("TRUNCATE TABLE test");
    }

    private long count() throws SQLException {
        return (long) sqlUtils.selectValue("select count(1) from test");
    }

    @Test
    public void test() throws Exception {
        clear();
        path("/tran/test").get();
        path("/tran/test").get();
        path("/tran/test").get();
        assert count() == 6;
    }

    @Test
    public void test2() throws Exception {
        clear();
        path("/tran/test2").get();
        path("/tran/test2").get();
        path("/tran/test2").get();
        assert count() == 0;
    }

    @Test
    public void test11() throws Exception {
        clear();
        path("/tran/test11").get();
        path("/tran/test11").get();
        path("/tran/test11").get();
        assert count() == 3;
    }

    @Test
    public void test12() throws Exception {
        clear();
        path("/tran/test12").get();
        path("/tran/test12").get();
        path("/tran/test12").get();
        assert count() == 3;
    }

    @Test
    public void test21() throws Exception {
        clear();
        path("/tran/test21").get();
        path("/tran/test21").get();
        path("/tran/test21").get();
        assert count() == 3;
    }

    @Test
    public void test22() throws Exception {
        clear();
        path("/tran/test22").get();
        path("/tran/test22").get();
        path("/tran/test22").get();
        long count = count();
        System.out.println(count);
        assert count == 0;
    }


    @Test
    public void test41() throws Exception {
        clear();
        path("/tran/test41").get();
        path("/tran/test41").get();
        path("/tran/test41").get();

        long count = count();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test51() throws Exception {
        clear();
        path("/tran/test51").get();
        path("/tran/test51").get();
        path("/tran/test51").get();

        long count = count();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test61() throws Exception {
        clear();
        path("/tran/test61").get();
        path("/tran/test61").get();
        path("/tran/test61").get();

        long count = count();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test63() throws Exception {
        clear();
        path("/tran/test63").get();
        path("/tran/test63").get();
        path("/tran/test63").get();

        long count = count();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test71() throws Exception {
        clear();
        path("/tran/test71").get();
        path("/tran/test71").get();
        path("/tran/test71").get();

        long count = count();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test73() throws Exception {
        clear();
        path("/tran/test73").get();
        path("/tran/test73").get();
        path("/tran/test73").get();

        long count = count();
        System.out.println(count);
        assert count == 0;
    }
}
