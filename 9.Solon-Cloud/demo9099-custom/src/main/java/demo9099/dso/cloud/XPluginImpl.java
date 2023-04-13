package demo9099.dso.cloud;

import org.noear.solon.cloud.CloudManager;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;
import org.noear.wood.DbContext;

/**
 * @author noear 2023/4/13 created
 */
public class XPluginImpl implements Plugin {
    @Override
    public void start(AopContext context) throws Throwable {
        DbContext db = context.cfg().getBean("demo.db1", DbContext.class);

        //完成 solon cloud 规范注册
        CloudConfigServiceOfDbImpl configService = new CloudConfigServiceOfDbImpl(db);
        CloudManager.register(configService);

        //也把它做为solon bean 规范注册 //在数据库管理时，可以调用 ::notice() 函数通知更新
        context.wrapAndPut(CloudConfigServiceOfDbImpl.class, configService);
    }
}
