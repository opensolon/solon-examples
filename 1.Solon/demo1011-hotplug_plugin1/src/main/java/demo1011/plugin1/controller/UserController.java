package demo1011.plugin1.controller;

import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

import java.util.Map;

/**
 * @Author: 李涵祥
 * @Date: 2022/5/15 12:39
 */
@Mapping("user")
@Controller
public class UserController {

    @Inject("${user.name}")
    String userName = "111";

    @Db
    DbContext db;

    @Mapping("/t")
    public String a() throws Exception {
        Map tmp = db.table("appx")
                .limit(1)
                .selectMap("*");

        return userName + "-" + ONode.stringify(tmp);
    }
}
