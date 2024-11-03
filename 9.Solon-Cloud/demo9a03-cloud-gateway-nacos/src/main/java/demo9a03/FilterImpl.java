package demo9a03;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear 2024/11/3 created
 */
@Component
public class FilterImpl implements Filter {
    static Logger log = LoggerFactory.getLogger(FilterImpl.class);

    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        log.warn("{} {}", ctx.method(), ctx.path());
        chain.doFilter(ctx);
    }
}
