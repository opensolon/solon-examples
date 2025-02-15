package features.h2;

import io.r2dbc.spi.ConnectionFactory;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.rx.sql.RxSqlExecutor;
import org.noear.solon.data.rx.sql.RxSqlUtilsFactory;
import org.noear.solon.data.rx.sql.impl.SimpleRxSqlExecutor;

import java.util.Arrays;

/**
 * @author noear 2024/11/6 created
 */
@Component
public class SqlUtilsFactoryImpl implements RxSqlUtilsFactory {
    @Override
    public RxSqlExecutor create(ConnectionFactory ds, String sql) {
        return new SimpleRxSqlExecutor(ds, sql).onCommandPost(cmd -> {
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
