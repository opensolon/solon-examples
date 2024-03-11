package demo7023.dso.api;

import demo7023.config.NamiConfig;
import demo7023.model.User;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.annotation.NamiMapping;

@NamiClient(url = "http://127.0.0.1:8080/users/", configuration = NamiConfig.class)
public interface RemoteService2 {

    @NamiMapping("GET get1?name={name}")
    String getOwner(String name);

    @NamiMapping("GET get2?name={name}")
    User get2(String name);
}
