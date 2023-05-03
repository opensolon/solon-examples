package demo4021.dso.aot;

import com.mysql.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import demo4021.dso.mapper.AppxMapper;
import demo4021.model.AppxModel;
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
    public void register(AopContext context, RuntimeNativeMetadata metadata) {
        metadata.registerResourceInclude("com.mysql.jdbc.LocalizedErrorMessages.properties");
        metadata.registerResourceInclude("demo4021/dso/mapper/.*");

        metadata.registerJdkProxy(AppxMapper.class);

        metadata.registerReflection(Driver.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }
}
