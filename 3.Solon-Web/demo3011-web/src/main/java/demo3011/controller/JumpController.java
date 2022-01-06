package demo3011.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

@Controller
public class JumpController {

    @Mapping("/jump/")
    public void jump(Context ctx) {
        ctx.redirect("http://www.noear.org");
    }
}
