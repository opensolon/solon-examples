package features;

import demo4072.DemoApp;
import demo4072.dso.mapper.AppxMapper;
import net.hasor.dbvisitor.solon.annotation.Db;
import org.junit.jupiter.api.Test;

import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class InsertTest {

    @Db
    AppxMapper appxMapper;

    @Test
    public void test(){

       long id =  appxMapper.appx_add2(12912);
       System.out.println(id);
    }
}
