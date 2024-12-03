package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;
import demo4035.DemoApp;
import demo4035.dso.mapper.AppxMapper;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class InsertTest {

    @Inject
    AppxMapper appxMapper;

    @Test
    public void test(){

       long id =  appxMapper.appx_add2(12912);
       System.out.println(id);
    }
}
