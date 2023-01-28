package demo5051.controller;

import tech.powerjob.solon.annotation.PowerJob;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

import java.util.Date;

@PowerJob
public class Job1 implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        return new ProcessResult(true, "Hello World! " + new Date());
    }
}
