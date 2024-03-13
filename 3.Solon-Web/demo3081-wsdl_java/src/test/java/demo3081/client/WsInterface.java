package demo3081.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.xcc.com/")
public interface WsInterface {
    @WebMethod
    public String sayInputName(String name);
}
