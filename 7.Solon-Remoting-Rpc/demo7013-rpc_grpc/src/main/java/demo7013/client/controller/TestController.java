package demo7013.client.controller;

import demo7013.service.hello.HelloHttpGrpc;
import demo7013.service.hello.HelloHttpRequest;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.extend.grpc.annotation.GrpcClient;

/**
 * @author noear 2022/6/20 created
 */
@Controller
public class TestController {

    @GrpcClient("demo-grpc")
    HelloHttpGrpc.HelloHttpBlockingStub helloHttp;

    @Mapping("/grpc/")
    public String test() {
        HelloHttpRequest request = HelloHttpRequest.newBuilder().setMsg("test").build();

        return helloHttp.sayHello(request).getMsg();
    }
}
