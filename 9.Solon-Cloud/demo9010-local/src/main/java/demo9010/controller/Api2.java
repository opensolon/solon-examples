package demo9010.controller;

import demo9010.dso.Rpc1;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2024/3/20 created
 */
@Mapping("api2")
@Controller
public class Api2 {
    @NamiClient(localFirst = true)
    Rpc1 rpc1;

    @Mapping("test")
    public String list2() {
        return "test: " + rpc1.list2();
    }
}
