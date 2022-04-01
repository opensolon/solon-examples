package demoa001.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;

/**
 * 接口组件测试
 *
 * @author noear 2022/4/1 created
 */
@Mapping
@Component(tag = "api")
public class ApiComponent {
    /**
     * hello
     *
     * @param name 用户
     * @return
     */
    @Mapping("api.hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
