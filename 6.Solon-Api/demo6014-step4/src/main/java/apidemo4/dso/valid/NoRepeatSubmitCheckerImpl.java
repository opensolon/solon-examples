package apidemo4.dso.valid;

import org.noear.redisx.RedisClient;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Context;
import org.noear.solon.validation.annotation.NoRepeatSubmit;
import org.noear.solon.validation.annotation.NoRepeatSubmitChecker;

/**
 * @author noear 2021/10/12 created
 */
@Component
public class NoRepeatSubmitCheckerImpl implements NoRepeatSubmitChecker {
    @Inject
    RedisClient redisClient;

    @Override
    public boolean check(NoRepeatSubmit anno, Context ctx, String submitHash, int limitSeconds) {
        return redisClient.getLock(submitHash).tryLock(limitSeconds);
    }
}
