package features;

import demo4091.DemoApp;
import demo4091.service.AppService;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sqlink.core.api.client.Client;
import org.noear.solon.test.SolonTest;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class AnnoTest
{

    @Inject
    AppService appService;

    @Test
    public void test()
    {
        assert !appService.listTables().isEmpty();
    }
}
