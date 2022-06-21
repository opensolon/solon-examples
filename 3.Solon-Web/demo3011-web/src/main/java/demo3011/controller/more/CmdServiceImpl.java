package demo3011.controller.more;

import org.noear.solon.aspect.annotation.Service;

/**
 * @author noear 2021/6/28 created
 */
@Service
public class CmdServiceImpl implements CmdService {
    public String name(String name) {
        return name;
    }
}
