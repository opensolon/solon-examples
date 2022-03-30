package demo4031.controller;

import demo4031.dso.service.AppServicePlus;
import demo4031.model.AppxModel;
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
    AppServicePlus appServicePlus;

    @Mapping("test")
    public AppxModel test() {
        return appServicePlus.getById(12);
    }
}
