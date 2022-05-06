package demo5092.controller;

import org.noear.solon.cloud.CloudJobHandler;
import org.noear.solon.cloud.annotation.CloudJob;
import org.noear.solon.core.handle.Context;

/**
 * @author noear 2021/5/25 created
 */
@CloudJob("JobHandlerDemo1")
public class JobHandlerDemo1 implements CloudJobHandler {
    @Override
    public void handle(Context ctx) throws Throwable {
        System.out.println("JobHandlerDemo1");
    }
}
