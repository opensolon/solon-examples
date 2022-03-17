package demo5012.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.extend.schedule.IJob;

import java.time.LocalDateTime;

/**
 * @author noear 2022/3/17 created
 */
@Component
public class Job1 implements IJob {
    @Override
    public int getInterval() {
        return 1000;
    }

    @Override
    public void exec() throws Throwable {
        System.out.println(LocalDateTime.now());
    }
}
