package demo3011.controller.more;

import org.noear.solon.annotation.Before;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2020/12/14 created
 */
@Controller
public class InterceptController {

    @Before(Before1.class)
    @Mapping("/demo2/intercept/demo")
    public String demo() throws Exception{
        return "demo";
    }

    public static class Before1 implements Handler{

        @Override
        public void handle(Context ctx) throws Throwable {
            ctx.output("intercept");
        }
    }
}
