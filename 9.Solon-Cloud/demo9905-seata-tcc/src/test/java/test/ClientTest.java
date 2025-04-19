package test;

import client.ClientApp;
import demo9905.protocol.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author noear 2021/1/18 created
 */

@SolonTest(ClientApp.class)
public class ClientTest extends HttpTester {

    //这是本地的
    @Inject
    HelloService localService;
    //这是远程的
    @NamiClient
    HelloService remoteService;
    @Inject
    private SqlUtils sqlUtils;

    @Bean
    public void init() throws SQLException, IOException {
        this.sqlUtils.initDatabase("classpath:db.sql");
    }

    @BeforeEach
    public void before() throws SQLException {
        this.sqlUtils.sql("delete from demo").update();
        this.localService.init();
        this.remoteService.init();
    }

    @Test
    public void testRemoteRollback() throws SQLException {
        path("/insert").data("code", "remote").get();
        assert this.remoteService.getPrepareExeStatus() == true;
        assert this.remoteService.getCommitExeStatus() == false;
        assert this.remoteService.getRollbackExeStatus() == true;
        assert this.localService.getPrepareExeStatus() == false;
        assert this.localService.getCommitExeStatus() == false;
        assert this.localService.getRollbackExeStatus() == false;
    }

    @Test
    public void testLocalRollback() throws SQLException {
        path("/insert").data("code", "local").get();
        assert this.remoteService.getPrepareExeStatus() == true;
        assert this.remoteService.getCommitExeStatus() == false;
        assert this.remoteService.getRollbackExeStatus() == true;
        assert this.localService.getPrepareExeStatus() == true;
        assert this.localService.getCommitExeStatus() == false;
        assert this.localService.getRollbackExeStatus() == true;
    }

    @Test
    public void testTestRollback() throws SQLException {
        path("/insert").data("code", "insert").get();
        assert this.remoteService.getPrepareExeStatus() == true;
        assert this.remoteService.getCommitExeStatus() == false;
        assert this.remoteService.getRollbackExeStatus() == true;
        assert this.localService.getPrepareExeStatus() == true;
        assert this.localService.getCommitExeStatus() == false;
        assert this.localService.getRollbackExeStatus() == true;
    }

    @Test
    public void testXxRollback() throws SQLException {
        path("/insert").data("code", "xx").get();
        assert this.remoteService.getPrepareExeStatus() == true;
        assert this.remoteService.getCommitExeStatus() == true;
        assert this.remoteService.getRollbackExeStatus() == false;
        assert this.localService.getPrepareExeStatus() == true;
        assert this.localService.getCommitExeStatus() == true;
        assert this.localService.getRollbackExeStatus() == false;
    }
}
