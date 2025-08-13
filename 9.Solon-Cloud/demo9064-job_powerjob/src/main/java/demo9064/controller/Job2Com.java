package demo9064.controller;

import org.noear.snack.ONode;
import org.noear.solon.annotation.Managed;
import org.noear.solon.cloud.annotation.CloudJob;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;

/**
 * @author noear 2023/1/29 created
 */
@Managed
public class Job2Com {
    /**
     * 会转为 PowerJobProxy implements BasicProcessor 处理
     * */
    @CloudJob("job2")
    public ProcessResult job2(TaskContext taskContext){
        System.out.println(ONode.stringify(taskContext));
        System.out.println("xxxxx - job2");

        return new ProcessResult(true,"test!");
    }
}
