package demo1011.plugin1.controller;

import demo1011.plugin1.controller.BaseController;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

import java.util.Map;

/**
 * @Author: 李涵祥
 * @Date: 2022/5/15 12:39
 */
@Mapping("user")
@Controller
public class UserController extends BaseController {

    @Inject("${user.name}")
    String userName = "111";

    @Db
    DbContext db;

    @Mapping("/t")
    public String t() throws Exception {
        Map tmp = db.table("appx")
                .limit(1)
                .selectMap("*");

        return userName + "-" + ONode.stringify(tmp);
    }

    @Mapping("/v")
    public ModelAndView v(Context ctx){
       return new ModelAndView("hello.ftl");
    }
}
