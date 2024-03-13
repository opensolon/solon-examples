package demo3082.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

//配置 WebService 接口
@WebService(serviceName = "HelloService", targetNamespace = "http://demo.solon.io")
public interface HelloService {
    @WebMethod
    String hello(String name);
}