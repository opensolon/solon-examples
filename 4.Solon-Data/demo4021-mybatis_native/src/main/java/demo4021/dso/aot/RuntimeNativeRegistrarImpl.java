package demo4021.dso.aot;

import org.noear.solon.annotation.Managed;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.core.AppContext;

/**
 * @author noear 2023/4/27 created
 */
@Managed
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        metadata.registerResourceInclude("com.mysql.jdbc.LocalizedErrorMessages.properties");
        metadata.registerResourceInclude("demo4021/dso/mapper/.*");
    }
}
