package demo3011.controller.more;

import org.noear.solon.annotation.ProxyComponent;

/**
 * @author noear 2021/6/28 created
 */
@ProxyComponent
public class CmdServiceImpl implements CmdService {
    public String name(String name) {
        return name;
    }
}
