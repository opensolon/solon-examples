package demo4002.controller;

import demo4002.dso.SqlMapper;
import demo4002.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.dynamicds.DynamicDs;
import org.noear.solon.data.dynamicds.DynamicDsKey;
import org.noear.wood.annotation.Db;

/**
 * @author noear 2022/11/23 created
 */
@Mapping("/dynamic/")
@Controller
public class DynamicController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Db("db2")
    SqlMapper sqlMapper1;



    @DynamicDs("db_rock1")
    @Mapping("/test1")
    public AppxModel test1() throws Exception{
        System.out.println("ds===" + DynamicDsKey.getCurrent());

        return sqlMapper1.appx_get2(1);
    }


    @DynamicDs("db_rock2")
    @Mapping("/test2")
    public AppxModel test2() throws Exception{
        System.out.println("ds===" + DynamicDsKey.getCurrent());

        return sqlMapper1.appx_get2(2);
    }


    @DynamicDs
    @Mapping("/test3")
    public AppxModel test3() throws Exception{
        System.out.println("ds===" + DynamicDsKey.getCurrent());

        return sqlMapper1.appx_get2(3);
    }
}
