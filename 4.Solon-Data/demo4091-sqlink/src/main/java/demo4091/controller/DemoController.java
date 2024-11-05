package demo4091.controller;

//import com.sun.tools.javac.jvm.ClassReader;
import demo4091.model.AppxModel;
import demo4091.service.AppService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.sqlink.api.client.SQLinkClient;

import java.util.List;

@Mapping("/demo/")
@Controller
public class DemoController
{

    @Inject
    AppService appService;

    @Inject
    SQLinkClient client;

    @Mapping("test")
    public AppxModel test()
    {
        return appService.getOne();
    }

    @Mapping("test2")
    public AppxModel test2()
    {
        return appService.getOneById(1);
    }

    @Mapping("test3")
    public List<AppxModel> test3()
    {
        return appService.getAll();
    }

    @Mapping("hello")
    public String hello(String name)
    {
        return appService.hello(name);
    }
}
