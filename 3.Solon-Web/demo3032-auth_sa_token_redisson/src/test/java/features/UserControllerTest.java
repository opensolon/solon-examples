package features;

import demo3032.WebApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit5Extension;
import org.noear.solon.test.SolonTest;



@SolonTest(classes = WebApp.class)
public class UserControllerTest extends HttpTester {
    @Test
    public void doLogin() throws Exception {
        assert "登录成功".equals(path("/user/doLogin?username=zhang&password=123456").get());
    }
}
