package demo4014.controller;

import demo4014.dso.mapper.SqlMapper;
import demo4014.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.datasource.dynamic.annotation.DynamicDsHolder;
import org.noear.solon.data.datasource.dynamic.annotation.DynamicDs;
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
        System.out.println("ds===" + DynamicDsHolder.get());

        return sqlMapper1.appx_get2(1);
    }


    @DynamicDs("db_rock2")
    @Mapping("/test2")
    public AppxModel test2() throws Exception{
        System.out.println("ds===" + DynamicDsHolder.get());

        return sqlMapper1.appx_get2(2);
    }


    @DynamicDs
    @Mapping("/test3")
    public AppxModel test3() throws Exception{
        System.out.println("ds===" + DynamicDsHolder.get());

        return sqlMapper1.appx_get2(3);
    }
}
