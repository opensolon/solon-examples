package features.h2;

import org.noear.solon.annotation.Component;
import org.noear.solon.data.sql.SqlExecutor;
import org.noear.solon.data.sql.SqlUtilsFactory;
import org.noear.solon.data.sql.impl.SimpleSqlExecutor;

import javax.sql.DataSource;

/**
 * @author noear 2024/11/6 created
 */
@Component
public class SqlUtilsFactoryImpl implements SqlUtilsFactory {
    @Override
    public SqlExecutor create(DataSource ds, String sql) {
        return new SimpleSqlExecutor(ds, sql).onExecuteBefore(cmd -> {
            System.out.println("sql:" + cmd.getSql());
            if (cmd.isBatch()) {
                System.out.println("args:" + cmd.getArgsColl());
            } else {
                System.out.println("args:" + cmd.getArgs());
            }
            System.out.println("----------");
        });
    }
}
