package demoX001;

import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;

import static com.cronutils.model.CronType.QUARTZ;

public class CronDemo {
    public static void main(String[] args) {
        CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(QUARTZ);
        CronParser parser = new CronParser(cronDefinition);

        ExecutionTime executionTime = ExecutionTime.forCron(parser.parse("*/45 * * * * ?"));
        Optional<ZonedDateTime> zonedDateTime = executionTime.nextExecution(ZonedDateTime.now());
        System.err.println("下次执行时间: " + zonedDateTime.toString());

        Optional<ZonedDateTime> zonedDateTime1 = executionTime.lastExecution(ZonedDateTime.now());
        System.err.println("最后执行时间: " + zonedDateTime1.toString());

        ZonedDateTime timeForLast = ZonedDateTime.now();
        Optional<Duration> duration = executionTime.timeFromLastExecution(timeForLast);
        System.err.println("最后一次执行时间过去了: " + duration + " 秒");

        Optional<Duration> duration1 = executionTime.timeToNextExecution(ZonedDateTime.now());
        System.err.println("距离下次执行时间: " + duration1);
    }
}