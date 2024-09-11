package demo3011.controller;

import org.noear.solon.annotation.Addition;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2020/12/14 created
 */
@Mapping("/render/direct/")
@Controller
public class RenderDirectController {

    @Addition(Before1.class)
    @Mapping("demo")
    public void demo() {

    }

    public static class Before1 implements Filter {
        @Override
        public void doFilter(Context ctx, FilterChain chain) throws Throwable {
            ctx.attrSet("@render", "@type_json");
            chain.doFilter(ctx);
        }
    }
}
