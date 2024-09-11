package features;

import org.apache.ibatis.solon.annotation.Db;
import org.junit.jupiter.api.Test;

import org.noear.solon.test.SolonTest;
import demo4021.DemoApp;
import demo4021.dso.mapper.AppxMapper;

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
