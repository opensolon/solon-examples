package demo7021.dso.api;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import demo7021.model.User;

public interface RemoteService {

    @RequestLine("GET /users/get1?name={name}")
    String getOwner(@Param("name") String name);

    @RequestLine("GET /users/get2?name={name}")
    User get2(String name);

    @RequestLine("POST setJson")
    @Headers("Content-Type: application/json")
    @Body("{body}")
    User setJson(@Param("body") String body);
}
