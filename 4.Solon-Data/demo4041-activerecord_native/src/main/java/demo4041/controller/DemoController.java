package demo4041.controller;

import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.solon.annotation.Db;
import demo4041.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/5/24 created
 */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Db
    DbPro db1;

    @Mapping("")
    public Record test(){
        return db1.template("appx_get").findFirst();
    }

    @Mapping("/test2")
    public AppxModel test2(){
        AppxModel dao = new AppxModel().dao();

        return dao.findById(4);
    }
}
