package demo4051.dso.aot;

import com.mysql.jdbc.Driver;
import demo4051.dso.dao.AppxDao;
import demo4051.dso.mapper.SqlMapper;
import org.beetl.sql.ext.DebugInterceptor;
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
        metadata.registerResourceInclude("sql/.*");

        metadata.registerJdkProxy(SqlMapper.class);
        metadata.registerJdkProxy(AppxDao.class);

        metadata.registerReflection(DebugInterceptor.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        metadata.registerReflection(Driver.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }
}
