package demo4002.dso;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.dynamicds.DynamicDs;
import org.noear.solon.data.dynamicds.DynamicDsHolder;
import org.noear.wood.annotation.Db;

/**
 * @author noear 2023/9/1 created
 */
@Component
public class DynamicService {
    /**
     * 使用SqlMapper默认的数据库注入
     */
    @Db("db2")
    SqlMapper sqlMapper1;


    @DynamicDs("db_rock1")
    public String test1() throws Exception {
        System.out.println("ds===" + DynamicDsHolder.get());
        sqlMapper1.appx_get2(1);
        return DynamicDsHolder.get();
    }


    @DynamicDs("db_rock2")
    @Mapping("/test2")
    public String test2() throws Exception {
        System.out.println("ds===" + DynamicDsHolder.get());
        sqlMapper1.appx_get2(2);
        return DynamicDsHolder.get();
    }


    @DynamicDs
    @Mapping("/test3")
    public String test3() throws Exception {
        System.out.println("ds===" + DynamicDsHolder.get());
        sqlMapper1.appx_get2(3);
        return DynamicDsHolder.get();
    }
}
