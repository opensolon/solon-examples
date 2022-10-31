package demo7021.dso.api;

import demo7021.config.JacksonConfig;
import feign.Param;
import feign.RequestLine;
import feign.solon.FeignClient;
import demo7021.model.User;

@FeignClient(url = "http://127.0.0.1:8080", path = "/users/", configuration = JacksonConfig.class)
public interface RemoteService2 {

    @RequestLine("GET get1?name={name}")
    String getOwner(@Param(value = "name") String name);

    @RequestLine("GET get2?name={name}")
    User get2(String name);
}
