package features;

import demo4091.DemoApp;
import demo4091.service.AppService;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;

@SolonTest(DemoApp.class)
public class InsertTest {
    @Inject
    AppService appService;

    @Test
    public void test() {
        long row = appService.appx_add2(12912);
        assert row == 1;
    }
}
