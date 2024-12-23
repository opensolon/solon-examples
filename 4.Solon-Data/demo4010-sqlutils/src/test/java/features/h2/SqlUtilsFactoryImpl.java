package features.h2;

import org.noear.solon.annotation.Component;
import org.noear.solon.data.sql.SqlExecutor;
import org.noear.solon.data.sql.SqlUtilsFactory;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author noear 2024/11/6 created
 */
@Component
public class SqlUtilsFactoryImpl implements SqlUtilsFactory {
    @Override
    public SqlExecutor create(DataSource ds, String sql, Object... args) {
        System.out.println("sql:" + sql);
        System.out.println("args:" + Arrays.toString(args));
        System.out.println("----------");

        return SqlUtilsFactory.super.create(ds, sql, args);
    }
}
