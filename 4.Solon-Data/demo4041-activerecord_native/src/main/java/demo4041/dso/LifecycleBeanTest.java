package demo4041.dso;

import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.solon.annotation.Db;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.bean.LifecycleBean;

/**
 * @author noear 2023/3/2 created
 */
@Component
public class LifecycleBeanTest implements LifecycleBean {
    @Db
    DbPro db1;

    @Override
    public void start() throws Throwable {
        System.out.println("============ start");
    }
}
