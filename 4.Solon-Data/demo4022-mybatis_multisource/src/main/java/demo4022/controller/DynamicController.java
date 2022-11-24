package demo4022.controller;

import demo4022.dso.mapper.Appx2Mapper;
import demo4022.model.AppxModel;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.datasource.dynamic.DynamicDsUtils;
import org.noear.solon.data.datasource.dynamic.annotation.DynamicDs;

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
    Appx2Mapper sqlMapper1;



    @DynamicDs("db_rock1")
    @Mapping("/test1")
    public AppxModel test1() throws Exception{
        System.out.println("ds===" + DynamicDsUtils.getCurrent());

        return sqlMapper1.appx_get2(1);
    }


    @DynamicDs("db_rock2")
    @Mapping("/test2")
    public AppxModel test2() throws Exception{
        System.out.println("ds===" + DynamicDsUtils.getCurrent());

        return sqlMapper1.appx_get2(2);
    }


    @DynamicDs
    @Mapping("/test3")
    public AppxModel test3() throws Exception{
        System.out.println("ds===" + DynamicDsUtils.getCurrent());

        return sqlMapper1.appx_get2(3);
    }
}
