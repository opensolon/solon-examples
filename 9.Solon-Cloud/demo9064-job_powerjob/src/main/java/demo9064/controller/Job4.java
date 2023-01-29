package demo9064.controller;

import org.noear.solon.cloud.annotation.CloudJob;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BroadcastProcessor;

import java.util.Date;

/**
 * @author noear 2023/1/29 created
 */
@CloudJob
public class Job4 implements BroadcastProcessor {
    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        System.out.println("ddddd");
        return new ProcessResult(true, "Hello Job! " + new Date());
    }
}
