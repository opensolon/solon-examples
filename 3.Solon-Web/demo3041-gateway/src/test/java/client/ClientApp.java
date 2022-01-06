package client;

import demo3041.common.UserService;
import demo3041.server.WebApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.nami.annotation.NamiClient;
import org.noear.snack.ONode;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/4/22 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(WebApp.class)
public class ClientApp {
    @NamiClient(upstream = "http://localhost:8080/", path = "/api/rpc/user/")
    UserService userService;

    @Test
    public void test1() {
        Object user = userService.getUser();
        System.out.println(ONode.stringify(user));
    }
}
