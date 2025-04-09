package test;

import client.ClientApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import java.sql.SQLException;

/**
 * @author noear 2021/1/18 created
 */

@SolonTest(ClientApp.class)
public class ClientTest extends HttpTester {

    @Inject
    private SqlUtils sqlUtils;

    @BeforeEach
    public void before() throws SQLException {
        this.sqlUtils.sql("delete from demo").update();
    }

    @Test
    public void testRemoteRollback() throws SQLException {
        path("/insert").data("code", "remote").get();
        Long count = this.sqlUtils.sql("select count(*) from demo").queryValue();
        assert count == 0;
    }

    @Test
    public void testLocalRollback() throws SQLException {
        path("/insert").data("code", "local").get();
        Long count = this.sqlUtils.sql("select count(*) from demo").queryValue();
        assert count == 0;
    }

    @Test
    public void testTestRollback() throws SQLException {
        path("/insert").data("code", "insert").get();
        Long count = this.sqlUtils.sql("select count(*) from demo").queryValue();
        assert count == 0;
    }

    @Test
    public void testXxRollback() throws SQLException {
        path("/insert").data("code", "xx").get();
        Long count = this.sqlUtils.sql("select count(*) from demo").queryValue();
        assert count == 2;
    }
}
