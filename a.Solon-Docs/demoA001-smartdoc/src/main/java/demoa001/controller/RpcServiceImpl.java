package demoa001.controller;

import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;

/**
 * 远程服务测试
 *
 * @author noear
 */
@Remoting
@Mapping("/rpc")
public class RpcServiceImpl {
    /**
     * hello
     *
     * @param name 用户
     * @return
     */
    public String hello(String name) {
        return "Hello " + name;
    }
}
