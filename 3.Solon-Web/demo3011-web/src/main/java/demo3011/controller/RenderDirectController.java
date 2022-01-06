package demo3011.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

/**
 * @author noear 2020/12/14 created
 */
@Mapping("/render/direct/")
@Controller
public class RenderDirectController {
    @Mapping(value = "*", before = true)
    public void bef(Context ctx) {
        ctx.attrSet("@render", "@type_json");
    }

    @Mapping("demo")
    public void demo() {

    }
}
