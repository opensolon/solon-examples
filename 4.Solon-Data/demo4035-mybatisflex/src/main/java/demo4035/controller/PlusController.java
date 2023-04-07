package demo4035.controller;

import demo4035.dso.mapper.AppxMapperPlusEx;
import demo4035.model.AppxModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2022/3/28 created
 */
@Mapping("/plus/")
@Controller
public class PlusController {
    @Inject
    AppxMapperPlusEx appServicePlus;

    @Mapping("test")
    public AppxModel test() {
        return appServicePlus.selectOneById(12);
    }
}
