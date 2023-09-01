package demo3011.controller.more;

import org.noear.solon.annotation.Component;

/**
 * @author noear 2021/6/28 created
 */
@Component
public class CmdServiceImpl implements CmdService {
    public String name(String name) {
        return name;
    }
}
