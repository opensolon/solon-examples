package demo7023.dso.api;

import demo7023.model.User;
import org.noear.nami.annotation.NamiMapping;

public interface RemoteService {

    @NamiMapping("GET /users/get1?name={name}")
    String getOwner(String name);

    @NamiMapping("GET /users/get2?name={name}")
    User get2(String name);
}
