package demo3011.controller;

import org.noear.solon.annotation.Before;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2020/12/14 created
 */
@Mapping("/render/direct/")
@Controller
public class RenderDirectController {

    @Before(Before1.class)
    @Mapping("demo")
    public void demo() {

    }

    public static class Before1 implements Handler{
        @Override
        public void handle(Context ctx) throws Throwable {
            ctx.attrSet("@render", "@type_json");
        }
    }
}
