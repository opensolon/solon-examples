package demo3011.dso;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;
import org.noear.solon.validation.annotation.Whitelist;
import org.noear.solon.validation.annotation.WhitelistValidator;

public class WhitelistValidatorImpl extends WhitelistValidator {
    @Override
    public Result validateOfContext(Context ctx, Whitelist anno, String name, StringBuilder tmp) {
        System.out.println("成功定制...");

        return Result.failure();
    }
}
