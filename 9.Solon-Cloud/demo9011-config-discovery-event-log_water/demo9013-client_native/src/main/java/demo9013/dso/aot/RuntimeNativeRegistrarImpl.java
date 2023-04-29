package demo9013.dso.aot;

import com.mysql.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AopContext;

/**
 * @author noear 2023/4/27 created
 */
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AopContext context, RuntimeNativeMetadata nativeMetadata) {
        nativeMetadata.registerResourceInclude("com.mysql.jdbc.LocalizedErrorMessages.properties");



        nativeMetadata.registerReflection(Driver.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        nativeMetadata.registerReflection(HikariConfig.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_PUBLIC_METHODS);
        nativeMetadata.registerReflection(HikariDataSource.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_PUBLIC_METHODS);

    }
}
