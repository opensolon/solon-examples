package demo9071.server;

import brave.Tracing;
import brave.opentracing.BraveTracer;
import io.opentracing.Tracer;
import org.noear.solon.Solon;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cloud.CloudProps;
import org.noear.solon.core.AopContext;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import java.net.URI;

/**
 * @author noear 2021/6/6 created
 */
@Configuration
public class Config {
    @Inject
    AopContext aopContext;

    @Bean
    public Tracer tracer()  {
        CloudProps cloudProps = new CloudProps(aopContext,"opentracing");


        if(cloudProps.getTraceEnable() == false){
            return null;
        }

        if(Utils.isEmpty(cloudProps.getServer())){
            return null;
        }

        Sender sender = OkHttpSender.create(cloudProps.getServer());

        Reporter<Span> spanReporter = AsyncReporter.create(sender);

        Tracing braveTracing = Tracing.newBuilder()
                .localServiceName(Solon.cfg().appName())
                .spanReporter(spanReporter)
                .build();

        return BraveTracer.create(braveTracing);
    }
}
