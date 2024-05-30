package features;

import demo4002.DemoApp;
import demo4002.dso.DynamicService;
import demo4002.dso.SqlMapper;
import demo4002.model.AppxModel;
import org.junit.jupiter.api.Test;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.annotation.Rollback;
import org.noear.wood.annotation.Db;

@SolonTest(DemoApp.class)
public class DynamicTest extends HttpTester {

    @Inject
    DynamicService dynamicService;

    @Db("db2")
    SqlMapper sqlMapper1;

    @Test
    public void test() throws Exception {
        String json1 = path("/dynamic/test1").get();
        String json2 = path("/dynamic/test2").get();
        String json3 = path("/dynamic/test3").get();

        AppxModel app1 = ONode.deserialize(json1, AppxModel.class);
        assert app1.getApp_id() == 1;

        AppxModel app2 = ONode.deserialize(json2, AppxModel.class);
        assert app2.getApp_id() == 2;

        AppxModel app3 = ONode.deserialize(json3, AppxModel.class);
        assert app3.getApp_id() == 3;
    }

    @Test
    public void test1() throws Exception{
        assert  "db_rock1".equals(dynamicService.test1());
        assert  "db_rock2".equals(dynamicService.test2());
        assert  "".equals(dynamicService.test3());
    }

    @Test
    public void test4() throws Exception{
        assert  "db_rock1".equals(dynamicService.test4("db_rock1"));
        assert  "db_rock2".equals(dynamicService.test4("db_rock2"));
        assert  "".equals(dynamicService.test4(""));
    }

    @Test
    public void test5() throws Exception{
        assert  "111".equals(dynamicService.test5("db_rock1"));
        assert  "222".equals(dynamicService.test5("db_rock2"));
        assert  "000".equals(dynamicService.test5("db_rock0"));
    }

    @Test
    @Tran
    public void tran() throws Exception{
        dynamicService.test_add("db_rock0", 1111);
        dynamicService.test_add("db_rock1", 2222);
        dynamicService.test_add("db_rock2", 3333);
    }

    @Test
    @Rollback
    public void tran2() throws Exception{
        dynamicService.test_add("db_rock0", 111999);
        dynamicService.test_add("db_rock1", 222999);
        dynamicService.test_add("db_rock2", 333999);
    }
}
