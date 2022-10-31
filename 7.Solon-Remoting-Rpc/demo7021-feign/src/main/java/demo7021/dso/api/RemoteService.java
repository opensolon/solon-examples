package demo7021.dso.api;

import feign.Param;
import feign.RequestLine;
import demo7021.model.User;

public interface RemoteService {

    @RequestLine("GET /users/get1?name={name}")
    String getOwner(@Param(value = "name") String name);

    @RequestLine("GET /users/get2?name={name}")
    User get2(String name);
}
