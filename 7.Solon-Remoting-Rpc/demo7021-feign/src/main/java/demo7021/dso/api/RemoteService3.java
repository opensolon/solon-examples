package demo7021.dso.api;

import demo7021.config.JacksonConfig;
import feign.Param;
import feign.RequestLine;
import org.noear.solon.extend.feign.FeignClient;
import demo7021.model.User;

@FeignClient(name = "user-service", path = "/users/", configuration = JacksonConfig.class)
public interface RemoteService3 {

    @RequestLine("GET get1?name={name}")
    String getOwner(@Param(value = "name") String name);

    @RequestLine("GET get2?name={name}")
    User get2(String name);
}
