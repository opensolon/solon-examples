package demo3011.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.validation.annotation.*;

@Valid  //为控制器开启校验能力；也可以做用在一个基类上
@Controller
public class ValidationController {

    @NoRepeatSubmit
    @NotNull({"name", "icon", "mobile"})
    @Mapping("/valid")
    public String test(String name, String icon, @Pattern("13\\d{9}") String mobile) {
        return "OK";
    }

    @Whitelist
    @Mapping("/valid/test2")
    public String test2() {
        return "OK";
    }
}
