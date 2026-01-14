package demo1001.demo5;

import org.noear.solon.core.aspect.Invocation;
import org.noear.solon.core.aspect.MethodInterceptor;

public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object doIntercept(Invocation inv) throws Throwable {
        System.out.println("before");
        Object rst = inv.invoke();
        System.out.println("after");
        return rst;
    }
}