package features.h2;

import org.noear.solon.annotation.Component;
import org.noear.solon.data.sql.SqlExecutor;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.data.sql.SqlUtilsFactory;
import org.noear.solon.data.sql.impl.SimpleSqlUtils;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author noear 2024/11/6 created
 */
@Component
public class SqlUtilsFactoryImpl implements SqlUtilsFactory {
    @Override
    public SqlUtils create(DataSource ds) {
        return new SimpleSqlUtils(ds){
            @Override
            public SqlExecutor sql(String sql, Object... args) {
                System.out.println("sql:" + sql);
                System.out.println("args:" + Arrays.toString(args));
                System.out.println("----------");

                return super.sql(sql, args);
            }
        };
    }
}
