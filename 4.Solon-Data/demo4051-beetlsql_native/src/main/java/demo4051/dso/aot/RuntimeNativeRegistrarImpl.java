package demo4051.dso.aot;

import org.antlr.v4.runtime.RuntimeMetaData;
import org.beetl.core.engine.BeetlAntlrParser49;
import org.beetl.sql.core.engine.BeetlSQLTemplateEngine;
import org.beetl.sql.ext.DebugInterceptor;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AopContext;

import java.lang.reflect.InvocationHandler;

/**
 * @author noear 2023/4/27 created
 */
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AopContext context, RuntimeNativeMetadata metadata) {
        metadata.registerResourceInclude("com.mysql.jdbc.LocalizedErrorMessages.properties");

        metadata.registerResourceInclude("btsql.properties");
        metadata.registerResourceInclude("org/beetl/core/beetl-default.properties");
        metadata.registerResourceInclude("beetl.properties");

        metadata.registerResourceInclude("sql/.*");

        metadata.registerReflection(RuntimeMetaData.class, MemberCategory.DECLARED_FIELDS);
        metadata.registerReflection(BeetlAntlrParser49.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS);


        //metadata.registerReflection(TypeNameFunction.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        metadata.registerReflection(BeetlSQLTemplateEngine.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        metadata.registerReflection(DebugInterceptor.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        metadata.registerReflection(InvocationHandler.class, MemberCategory.INVOKE_DECLARED_METHODS);
    }
}
