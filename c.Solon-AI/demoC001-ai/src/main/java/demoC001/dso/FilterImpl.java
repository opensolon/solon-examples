package demoC001.dso;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.noear.solon.rx.Completable;
import org.noear.solon.rx.handle.RxFilter;
import org.noear.solon.rx.handle.RxFilterChain;

/**
 * @author noear 2025/3/1 created
 */
@Component
public class FilterImpl implements Filter, RxFilter<Context> {
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Completable doFilter(Context context, RxFilterChain<Context> chain) {
        return chain.doFilter(context)
                .doOnError(err -> {
                    err.printStackTrace();
                });
    }
}
