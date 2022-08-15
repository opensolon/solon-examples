package demo4012.controller;

import demo4012.dso.mapper.SqlMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.weed.annotation.Db;

@Mapping("/demo/")
@Controller
public class DemoController {
    /**
     * 使用SqlMapper默认的数据库注入
     * */
    @Db
    SqlMapper sqlMapper1;

    /**
     * 使用指定数据库注入
     * */
    @Db("db2")
    SqlMapper sqlMapper2;

    @Mapping("/test")
    public Object db1() throws Exception{
        return sqlMapper1.appx_get2(1);
    }

    @Mapping("/test2")
    public Object db2() throws Exception{
        return sqlMapper2.appx_get2(1);
    }
}
