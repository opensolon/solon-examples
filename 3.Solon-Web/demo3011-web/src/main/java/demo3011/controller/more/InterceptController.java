package demo3011.controller.more;

import org.noear.solon.annotation.Addition;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;

/**
 * @author noear 2020/12/14 created
 */
@Controller
public class InterceptController {

    @Addition(Before1.class)
    @Mapping("/demo2/intercept/demo")
    public String demo() throws Exception{
        return "demo";
    }

    public static class Before1 implements Filter {

        @Override
        public void doFilter(Context ctx, FilterChain chain) throws Throwable {
            ctx.output("intercept");
        }
    }
}
