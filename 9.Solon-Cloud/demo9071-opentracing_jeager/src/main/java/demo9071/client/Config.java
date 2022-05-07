package demo9071.client;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.metrics.Metrics;
import io.jaegertracing.internal.metrics.NoopMetricsFactory;
import io.jaegertracing.internal.reporters.CompositeReporter;
import io.jaegertracing.internal.reporters.LoggingReporter;
import io.jaegertracing.internal.reporters.RemoteReporter;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.jaegertracing.thrift.internal.senders.UdpSender;
import io.opentracing.Tracer;
import org.apache.thrift.transport.TTransportException;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cloud.extend.opentracing.OpentracingProps;

/**
 * @author noear 2021/6/6 created
 */
@Configuration
public class Config {

    @Bean
    public Tracer tracer() throws TTransportException {
        String[] serverPort = OpentracingProps.instance.getServer().split(":");

        String server = serverPort[0];
        int port = Integer.parseInt(serverPort[1]);

        final CompositeReporter compositeReporter = new CompositeReporter(
                new RemoteReporter.Builder().withSender(new UdpSender(server, port, 0)).withFlushInterval(10).build(),
                new LoggingReporter()
        );

        final Metrics metrics = new Metrics(new NoopMetricsFactory());

        return new JaegerTracer.Builder(Solon.cfg().appName())
                .withReporter(compositeReporter)
                .withMetrics(metrics)
                .withExpandExceptionLogs()
                .withSampler(new ConstSampler(true)).build();
    }
}
