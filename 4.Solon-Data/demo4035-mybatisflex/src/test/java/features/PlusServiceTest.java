package features;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import demo4035.DemoApp;
import demo4035.dso.mapper.AppxMapperPlus;
import demo4035.dso.mapper.AppxMapperPlusEx;
import demo4035.model.AppxModel;
import org.apache.ibatis.solon.annotation.Db;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2022/3/28 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class PlusServiceTest {

    @Db
    AppxMapperPlus appxMapperPlus;

    @Db
    AppxMapperPlusEx appxMapperPlusEx;


    @Test
    public void selectById1() {
        AppxModel app = appxMapperPlus.selectOneById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }

    @Test
    public void selectById2() {
        AppxModel app = appxMapperPlusEx.selectOneById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }

    @Test
    public void selectOne() {
        Map<String,Object> map = new HashMap<>();
        map.put("app_id",2);

        AppxModel app = appxMapperPlusEx.selectOneByMap(map);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }


    @Test
    public void selectPage() {
        Page<AppxModel> page = new Page<>(1, 10);
        Page<AppxModel> iPage = appxMapperPlusEx.paginate(page, new QueryWrapper());


        assert iPage != null;

        System.out.println("iPage.getList().size(): " + iPage.getList().size());
        assert iPage.getList().size() > 0;

        System.out.println("iPage.getTotal(): " + iPage.getTotalRow());
        assert iPage.getTotalRow() > 0;
    }
}
