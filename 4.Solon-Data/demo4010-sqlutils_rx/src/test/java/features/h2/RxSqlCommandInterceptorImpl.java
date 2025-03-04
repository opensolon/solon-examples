package features.h2;

import org.noear.solon.annotation.Component;
import org.noear.solon.data.rx.sql.intercept.RxSqlCommandInterceptor;
import org.noear.solon.data.rx.sql.intercept.RxSqlCommandInvocation;
import org.reactivestreams.Publisher;


/**
 * @author noear 2024/11/6 created
 */
@Component
public class RxSqlCommandInterceptorImpl implements RxSqlCommandInterceptor {

    @Override
    public Publisher doIntercept(RxSqlCommandInvocation inv) {
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