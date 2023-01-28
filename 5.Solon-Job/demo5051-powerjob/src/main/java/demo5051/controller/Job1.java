package demo5051.controller;

import org.noear.solon.annotation.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

import java.util.Date;

@Component
public class Job1 implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        return new ProcessResult(true, "Hello World! " + new Date());
    }
}
