package features;

import demo4091.DemoApp;
import demo4091.service.AppService;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;


@SolonTest(DemoApp.class)
public class AnnoTest {
    @Inject
    AppService appService;

    @Test
    public void test() {
        assert !appService.listTables().isEmpty();
    }

    @Test
    public void test2() {
        assert appService.hello("world").equals("hello world");
    }
}
