package features;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit5Extension;
import org.noear.solon.test.SolonTest;
import demo4031.DemoApp;
import demo4031.dso.mapper.AppxMapper2;
import demo4031.model.AppxModel;
import com.baomidou.mybatisplus.core.metadata.IPage;


/**
 * @author noear 2021/9/3 created
 */
@ExtendWith(SolonJUnit5Extension.class)
@SolonTest(DemoApp.class)
public class PlusTest {

    @Inject
    AppxMapper2 appxMapper2;

    @Test
    public void selectById() {
        AppxModel app = appxMapper2.selectById(2);
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }

    @Test
    public void selectOne() {
        AppxModel app = appxMapper2.selectOne(new QueryWrapper<AppxModel>().eq("app_id",2));
        System.out.println(app);

        assert app != null;
        assert app.getAppId() == 2;
    }


    @Test
    public void selectPage() {
        Page<AppxModel> page = new Page<>(1, 10);
        IPage<AppxModel> iPage = appxMapper2.selectPage(page, new QueryWrapper<>());


        assert iPage != null;

        System.out.println("iPage.getRecords().size(): " + iPage.getRecords().size());
        assert iPage.getRecords().size() > 0;

        System.out.println("iPage.getTotal(): " + iPage.getTotal());
        assert iPage.getTotal() > 0;
    }
}
