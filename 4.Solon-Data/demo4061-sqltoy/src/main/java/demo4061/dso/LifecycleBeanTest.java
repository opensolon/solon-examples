package demo4061.dso;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import org.noear.solon.core.bean.LifecycleBean;
import org.sagacity.sqltoy.solon.annotation.Db;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;

/**
 * @author noear 2023/3/2 created
 */
@Component
public class LifecycleBeanTest implements LifecycleBean {
    @Db
    SqlToyLazyDao db1;

    @Init
    public void afterInjection() throws Throwable {
        System.out.println("============ afterInjection");
    }

    @Override
    public void start() throws Throwable {
        System.out.println("============ start");
    }
}
