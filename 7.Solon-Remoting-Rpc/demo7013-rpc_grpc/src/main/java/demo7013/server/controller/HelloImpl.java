package demo7013.server.controller;

import demo7013.service.hello.HelloHttpGrpc;
import demo7013.service.hello.HelloHttpRequest;
import demo7013.service.hello.HelloHttpResponse;
import io.grpc.stub.StreamObserver;

import org.noear.solon.extend.grpc.annotation.GrpcService;

/**
 * @author noear 2022/6/20 created
 */
@GrpcService
public class HelloImpl extends HelloHttpGrpc.HelloHttpImplBase{
    @Override
    public void sayHello(HelloHttpRequest request, StreamObserver<HelloHttpResponse> responseObserver) {
        String requestMsg = request.getMsg();
        String responseMsg = "hello " + requestMsg;
        HelloHttpResponse helloHttpResponse = HelloHttpResponse.newBuilder().setMsg(responseMsg).build();
        responseObserver.onNext(helloHttpResponse);
        responseObserver.onCompleted();
    }
}
