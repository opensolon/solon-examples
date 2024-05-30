package features;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import demo4035.DemoApp;
import demo4035.dso.mapper.AppxMapperPlus;
import demo4035.dso.mapper.AppxMapperPlusEx;
import demo4035.dso.service.AppServicePlus;
import demo4035.model.AppxModel;
import org.apache.ibatis.solon.annotation.Db;
import org.junit.jupiter.api.Test;

import org.noear.solon.annotation.Inject;

import org.noear.solon.test.SolonTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2022/3/28 created
 */

@SolonTest(DemoApp.class)
public class PlusServiceTest {

    @Inject
    AppServicePlus appServicePlus;
    @Inject
    AppServicePlus appServicePlus2;

    @Db
    AppxMapperPlus appxMapperPlus;

    @Db
    AppxMapperPlusEx appxMapperPlusEx;

    @Test
    public void selectById() {
        AppxModel app = appServicePlus.getById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }


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

        System.out.println("iPage.getList().size(): " + iPage.getRecords().size());
        assert iPage.getRecords().size() > 0;

        System.out.println("iPage.getTotal(): " + iPage.getTotalRow());
        assert iPage.getTotalRow() > 0;
    }

    @Test
    public void selectOne2() {
        AppxModel app = appServicePlus.getOne(new QueryWrapper().where("app_id=?",2));
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }


    @Test
    public void selectPage2() {
        Page<AppxModel> page = new Page<>(1, 10);
        Page<AppxModel> iPage = appServicePlus.page(page, new QueryWrapper());


        assert iPage != null;

        System.out.println("iPage.getRecords().size(): " + iPage.getRecords().size());
        assert iPage.getRecords().size() > 0;

        System.out.println("iPage.getTotal(): " + iPage.getTotalRow());
        assert iPage.getTotalRow() > 0;
    }
}
