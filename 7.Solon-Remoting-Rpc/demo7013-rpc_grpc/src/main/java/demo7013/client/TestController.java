package demo7013.client;

import demo7013.service.hello.HelloHttpGrpc;
import demo7013.service.hello.HelloHttpRequest;
import io.grpc.solon.annotation.GrpcClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;

/**
 * @author noear 2022/6/20 created
 */
@Controller
public class TestController {

    @GrpcClient("demo-grpc")
    HelloHttpGrpc.HelloHttpBlockingStub helloHttp;

    @Mapping("/hello")
    public String hello(@Param(defaultValue = "world") String name) {
        HelloHttpRequest request = HelloHttpRequest.newBuilder()
                .setMsg(name)
                .build();

        return helloHttp.sayHello(request).getMsg();
    }
}
