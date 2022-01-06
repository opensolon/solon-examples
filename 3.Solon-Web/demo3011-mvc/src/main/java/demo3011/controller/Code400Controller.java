package demo3011.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

/**
 * @author noear 2021/12/4 created
 */
@Controller
public class Code400Controller {
    @Mapping("/code/400")
    public String code400(Context ctx, String name) {
        if (Utils.isEmpty(name)) {
            ctx.status(400);
            return null;
        } else {
            return "Hello " + name;
        }
    }
}
