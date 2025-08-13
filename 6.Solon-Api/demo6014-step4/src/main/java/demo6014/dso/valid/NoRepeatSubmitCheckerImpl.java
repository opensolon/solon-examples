package demo6014.dso.valid;

import org.noear.redisx.RedisClient;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Context;
import org.noear.solon.validation.annotation.NoRepeatSubmit;
import org.noear.solon.validation.annotation.NoRepeatSubmitChecker;

/**
 * @author noear 2021/10/12 created
 */
@Managed
public class NoRepeatSubmitCheckerImpl implements NoRepeatSubmitChecker {
    @Inject
    RedisClient redisClient;

    @Override
    public boolean check(NoRepeatSubmit anno, Context ctx, String submitHash, int limitSeconds) {
        return redisClient.getLock(submitHash).tryLock(limitSeconds);
    }
}
