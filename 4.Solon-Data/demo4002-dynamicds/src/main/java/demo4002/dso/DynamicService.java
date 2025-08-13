package demo4002.dso;

import demo4002.model.AppxModel;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.dynamicds.DynamicDs;
import org.noear.solon.data.dynamicds.DynamicDsKey;
import org.noear.wood.annotation.Db;

/**
 * @author noear 2023/9/1 created
 */
@Managed
public class DynamicService {
    /**
     * 使用SqlMapper默认的数据库注入
     */
    @Db("db2")
    SqlMapper sqlMapper1;


    @DynamicDs("db_rock1")
    public String test1() throws Exception {
        System.out.println("ds===" + DynamicDsKey.getCurrent());
        sqlMapper1.appx_get2(1);
        return DynamicDsKey.getCurrent();
    }


    @DynamicDs("db_rock2")
    @Mapping("/test2")
    public String test2() throws Exception {
        System.out.println("ds===" + DynamicDsKey.getCurrent());
        sqlMapper1.appx_get2(2);
        return DynamicDsKey.getCurrent();
    }


    @DynamicDs
    @Mapping("/test3")
    public String test3() throws Exception {
        System.out.println("ds===" + DynamicDsKey.getCurrent());
        sqlMapper1.appx_get2(3);
        return DynamicDsKey.getCurrent();
    }

    @DynamicDs("${dsName}")
    @Mapping("/test4")
    public String test4(String dsName) throws Exception {
        System.out.println("ds===" + DynamicDsKey.getCurrent());
        return DynamicDsKey.getCurrent();
    }

    @DynamicDs("${dsName}")
    @Mapping("/test5")
    public String test5(String dsName) throws Exception {
        AppxModel app = sqlMapper1.appx_get2(3);
        System.out.println("ds===" + DynamicDsKey.getCurrent() + ": " + app.getNote());
        return app.getNote();
    }

    @DynamicDs("${dsName}")
    @Mapping("/test5")
    public String tran(String dsName) throws Exception {
        AppxModel app = sqlMapper1.appx_get2(3);
        System.out.println("ds===" + DynamicDsKey.getCurrent() + ": " + app.getNote());
        return app.getNote();
    }

    @DynamicDs("${dsName}")
    public void test_add(String dsName, int val) {
        sqlMapper1.test_add(val);
    }
}
