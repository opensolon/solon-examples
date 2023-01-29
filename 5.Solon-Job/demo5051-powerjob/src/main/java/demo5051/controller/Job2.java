package demo5051.controller;

import tech.powerjob.solon.annotation.PowerJob;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BroadcastProcessor;

import java.util.Date;

/**
 * @author noear 2023/1/29 created
 */
@PowerJob
public class Job2 implements BroadcastProcessor {
    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        System.out.println("ddddd");
        return new ProcessResult(true, "Hello Job! " + new Date());
    }
}
