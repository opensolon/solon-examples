package demo6014.dso.valid;

import org.noear.solon.annotation.Managed;
import org.noear.solon.core.handle.Context;
import org.noear.solon.validation.annotation.Logined;
import org.noear.solon.validation.annotation.LoginedChecker;

/**
 * @author noear 2021/6/17 created
 */
@Managed
public class LoginedCheckerImpl implements LoginedChecker {
    @Override
    public boolean check(Logined anno, Context ctx, String userKeyName) {
        Number user_id = ctx.sessionOrDefault("user_id", null);
        if (user_id != null) {
            return user_id.longValue() > 0L;
        } else {
            return false;
        }
    }
}
