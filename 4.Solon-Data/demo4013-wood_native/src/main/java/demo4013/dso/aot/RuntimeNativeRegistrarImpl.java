package demo4013.dso.aot;

import com.mysql.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import demo4013.dso.mapper.SqlMapper;
import demo4013.model.AppxModel;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.BeanNativeProcessor;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AopContext;
import org.noear.wood.impl.IMapperAdaptorPlusImpl;
import org.noear.wood.impl.IPageImpl;

/**
 * @author noear 2023/4/27 created
 */
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AopContext context, RuntimeNativeMetadata nativeMetadata) {
        nativeMetadata.registerResourceInclude("com.mysql.jdbc.LocalizedErrorMessages.properties");

        nativeMetadata.registerSerialization(AppxModel.class);


        nativeMetadata.registerReflection(Driver.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        nativeMetadata.registerReflection(SqlMapper.class, MemberCategory.INVOKE_DECLARED_METHODS);

        nativeMetadata.registerReflection(HikariConfig.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_PUBLIC_METHODS);
        nativeMetadata.registerReflection(HikariDataSource.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                MemberCategory.INVOKE_PUBLIC_METHODS);

    }
}
