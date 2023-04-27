package demo4021.dso.aot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import demo4021.model.AppxModel;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.BeanNativeProcessor;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.core.AopContext;

/**
 * @author noear 2023/4/27 created
 */
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {
    @Override
    public void register(AopContext context, RuntimeNativeMetadata nativeMetadata) {
        nativeMetadata.registerResourceInclude("demo4021/dso/mapper/.*\\.xml");

        nativeMetadata.registerSerialization(AppxModel.class);
        nativeMetadata.registerSerialization(HikariDataSource.class);
        nativeMetadata.registerSerialization(HikariConfig.class);

        BeanNativeProcessor bnp = nativeMetadata.beanNativeProcessor();

        bnp.processBean(nativeMetadata, HikariDataSource.class);
        bnp.processBeanFields(nativeMetadata, HikariDataSource.class);
        bnp.processBeanMethods(nativeMetadata, HikariDataSource.class);

        bnp.processBean(nativeMetadata, HikariConfig.class);
        bnp.processBeanFields(nativeMetadata, HikariConfig.class);
        bnp.processBeanMethods(nativeMetadata, HikariConfig.class);

    }
}
