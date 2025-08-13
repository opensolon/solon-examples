package features.h2;

import org.noear.solon.annotation.Managed;
import org.noear.solon.data.sql.intercept.SqlCommandInterceptor;
import org.noear.solon.data.sql.intercept.SqlCommandInvocation;

import java.sql.SQLException;

/**
 * @author noear 2024/11/6 created
 */
@Managed
public class SqlCommandInterceptorImpl implements SqlCommandInterceptor {
    @Override
    public Object doIntercept(SqlCommandInvocation inv) throws SQLException {
        System.out.println("sql:" + inv.getCommand().getSql());
        if (inv.getCommand().isBatch()) {
            System.out.println("args:" + inv.getCommand().getArgsColl());
        } else {
            System.out.println("args:" + inv.getCommand().getArgs());
        }
        System.out.println("----------");


        return inv.invoke();
    }
}
