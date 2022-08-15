package demo4011.controller;

import demo4011.dso.mapper.SqlMapper;
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


    @Mapping("/test")
    public Object db1() throws Exception{
        return sqlMapper1.appx_get2(1);
    }
}
