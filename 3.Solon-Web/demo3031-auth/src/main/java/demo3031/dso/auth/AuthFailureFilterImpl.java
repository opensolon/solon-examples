package demo3031.dso.auth;


import org.noear.solon.annotation.Managed;
import org.noear.solon.auth.AuthException;
import org.noear.solon.auth.AuthStatus;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.noear.solon.core.handle.Result;

/**
 * @author noear 2022/11/22 created
 */
@Managed
public class AuthFailureFilterImpl implements Filter {
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try{
            chain.doFilter(ctx);
        }catch (AuthException e){
            AuthStatus status = e.getStatus();
            ctx.render(Result.failure(status.code, status.message));
        }
    }
}
