package demo3082.client;

import org.noear.solon.annotation.Managed;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.web.webservices.WebServiceReference;

@Managed
public  class DemoCom implements LifecycleBean {
    @WebServiceReference("http://localhost:8080/ws/HelloService")
    private HelloService helloService;

    @Override
    public void start() throws Throwable {
        System.out.println("rst: " + helloService.hello("noear"));
    }
}