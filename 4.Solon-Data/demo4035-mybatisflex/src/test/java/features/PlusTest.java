package features;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import demo4035.DemoApp;
import demo4035.dso.mapper.AppxMapper2;
import demo4035.model.AppxModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

import java.util.HashMap;
import java.util.Map;


/**
 * @author noear 2021/9/3 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class PlusTest {

    @Inject
    AppxMapper2 appxMapper2;

    @Test
    public void selectById() {
        AppxModel app = appxMapper2.selectOneById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }

    @Test
    public void selectOne() {
        Map<String,Object> map = new HashMap<>();
        map.put("app_id",2);

        AppxModel app = appxMapper2.selectOneByMap(map);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }


    @Test
    public void selectPage() {
        Page<AppxModel> page = new Page<>(1, 10);
        Page<AppxModel> iPage = appxMapper2.paginate(page, new QueryWrapper());


        assert iPage != null;

        System.out.println("iPage.getList().size(): " + iPage.getRecords().size());
        assert iPage.getRecords().size() > 0;

        System.out.println("iPage.getTotal(): " + iPage.getTotalRow());
        assert iPage.getTotalRow() > 0;
    }
}
