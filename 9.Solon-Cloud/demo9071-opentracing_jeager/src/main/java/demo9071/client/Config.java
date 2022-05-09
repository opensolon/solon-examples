package demo9071.client;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.metrics.Metrics;
import io.jaegertracing.internal.metrics.NoopMetricsFactory;
import io.jaegertracing.internal.reporters.CompositeReporter;
import io.jaegertracing.internal.reporters.LoggingReporter;
import io.jaegertracing.internal.reporters.RemoteReporter;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.jaegertracing.spi.Sender;
import io.jaegertracing.thrift.internal.senders.UdpSender;
import io.opentracing.Tracer;
import org.apache.thrift.transport.TTransportException;
import org.noear.solon.Solon;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.cloud.CloudProps;
import org.noear.solon.cloud.extend.opentracing.OpentracingProps;

import java.net.URI;

/**
 * @author noear 2021/6/6 created
 */
@Configuration
public class Config {

    @Bean
    public Tracer tracer() throws TTransportException {
        CloudProps cloudProps = OpentracingProps.instance;

        //为了可自由配置，这行代码重要
        if(cloudProps.getTraceEnable() == false || Utils.isEmpty(cloudProps.getServer())){
            return null;
        }

        URI serverUri = URI.create(cloudProps.getServer());
        Sender sender = new UdpSender(serverUri.getHost(), serverUri.getPort(), 0);

        final CompositeReporter compositeReporter = new CompositeReporter(
                new RemoteReporter.Builder().withSender(sender).build(),
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
