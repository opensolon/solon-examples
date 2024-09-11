package demo4041.controller;

import com.jfinal.plugin.activerecord.solon.annotation.Db;
import demo4041.dso.mapper.SqlMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/5/24 created
 */
@Mapping("/mapper/")
@Controller
public class MapperController {
    @Db
    SqlMapper sqlMapper;

    @Mapping("")
    public Object test(){
        return sqlMapper.appx_get();
    }

    @Mapping("/test2")
    public Object test2(){
        return sqlMapper.appx_get2(4);
    }
}
