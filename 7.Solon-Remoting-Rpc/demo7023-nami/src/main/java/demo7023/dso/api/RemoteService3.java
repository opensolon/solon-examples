package demo7023.dso.api;

import demo7023.model.User;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.annotation.NamiMapping;

@NamiClient(name = "user-service", path = "/users/")
public interface RemoteService3 {

    @NamiMapping("GET get1?name={name}")
    String getOwner(String name);

    @NamiMapping("GET get2?name={name}")
    User get2(String name);
}
