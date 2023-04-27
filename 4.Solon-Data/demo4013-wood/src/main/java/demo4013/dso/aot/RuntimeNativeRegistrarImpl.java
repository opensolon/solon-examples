package demo4013.dso.aot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import demo4013.model.AppxModel;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.BeanNativeProcessor;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.core.AopContext;
import org.noear.wood.impl.IMapperAdaptorPlusImpl;

/**
 * @author noear 2023/4/27 created
 */
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AopContext context, RuntimeNativeMetadata nativeMetadata) {
        nativeMetadata.registerSerialization(AppxModel.class);

        BeanNativeProcessor bnp = nativeMetadata.beanNativeProcessor();

        bnp.processBean(nativeMetadata, HikariDataSource.class);
        bnp.processBeanFields(nativeMetadata, HikariDataSource.class);
        bnp.processBeanMethods(nativeMetadata, HikariDataSource.class);

        bnp.processBean(nativeMetadata, HikariConfig.class);
        bnp.processBeanFields(nativeMetadata, HikariConfig.class);
        bnp.processBeanMethods(nativeMetadata, HikariConfig.class);

    }
}
