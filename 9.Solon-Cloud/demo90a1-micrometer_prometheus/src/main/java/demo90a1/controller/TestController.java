package demo90a1.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.metrics.annotation.MeterCounter;
import org.noear.solon.cloud.metrics.annotation.MeterGauge;
import org.noear.solon.cloud.metrics.annotation.MeterSummary;
import org.noear.solon.cloud.metrics.annotation.MeterTimer;

@Controller
public class TestController {
    @Mapping("/counter")
    @MeterCounter("demo.counter")
    public String counter() {
        return "counter";
    }

    @Mapping("/gauge")
    @MeterGauge("demo.gauge")
    public Long gauge() {
        return System.currentTimeMillis() % 100;
    }

    @Mapping("/summary")
    @MeterSummary(value = "demo.summary",  minValue = 1, maxValue = 10, percentiles = {0.5, 0.90,0.95, 0.99})
    public Long summary() {
        return System.currentTimeMillis() % 10;
    }

    @Mapping("/timer")
    @MeterTimer("demo.timer")
    public String timer() {
        return "timer";
    }
}
