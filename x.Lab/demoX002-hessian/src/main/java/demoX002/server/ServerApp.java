package demoX002.server;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.MethodType;
import demoX002.server.controller.ComplexModelService;
import demoX002.server.dso.IComplexModelService;
import demoX002.server.wrap.HessianHandler;
import demoX002.server.dso.IGreetingService;

public class ServerApp {
    public static void main(String[] args) {
        Solon.start(ServerApp.class, args, app->{
            app.add("/web/hessian", MethodType.HTTP,
                    new HessianHandler(IGreetingService.class, Solon.context().getBean(IGreetingService.class)));


            app.add("/web/hessian_complex", MethodType.HTTP,
                    new HessianHandler(IComplexModelService.class, Solon.context().getBean(ComplexModelService.class)));
        });

        //HessianServlet
    }
}
