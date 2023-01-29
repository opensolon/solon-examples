package demo9064.controller;

import org.noear.solon.cloud.annotation.CloudJob;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

import java.util.Date;

@CloudJob("job3")
public class Job3 implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        return new ProcessResult(true, "Hello World! " + new Date());
    }
}
