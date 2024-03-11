package demo7023.controller;

import demo7023.dso.api.RemoteService;
import demo7023.model.User;
import org.noear.nami.Nami;
import org.noear.nami.coder.snack3.SnackDecoder;
import org.noear.nami.coder.snack3.SnackEncoder;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 手动构建
 * */
@Mapping("demo1")
@Controller
public class Demo1Controller {
    RemoteService service = Nami.builder()
            .upstream(()->"http://127.0.0.1:8080")
            .create(RemoteService.class);

    RemoteService service2 = Nami.builder()
            .encoder(new SnackEncoder())
            .decoder(new SnackDecoder())
            .upstream(()->"http://127.0.0.1:8080")
            .create(RemoteService.class);

    @Mapping("test")
    public String test() {
        String result = service.getOwner("scott");

        return result;
    }

    @Mapping("test2")
    public Object test2() {
        User user = service2.get2("scott");

        return user;
    }
}
