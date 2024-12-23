package features;

import com.mybatisflex.core.FlexGlobalConfig;
import demo4035.DemoApp;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2024/12/24 created
 */
@SolonTest(DemoApp.class)
public class ConfigTest {
    @Inject
    FlexGlobalConfig globalConfig;

    @Test
    public void test(){
        assert globalConfig != null;
        assert globalConfig.isPrintBanner() == false;
    }
}
