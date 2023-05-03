package demo4041.dso.aot;

import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.core.AopContext;

/**
 * @author noear 2023/4/27 created
 */
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AopContext context, RuntimeNativeMetadata metadata) {
        metadata.registerResourceInclude("com.mysql.jdbc.LocalizedErrorMessages.properties");

        metadata.registerResourceInclude("sql/.*");
    }
}
