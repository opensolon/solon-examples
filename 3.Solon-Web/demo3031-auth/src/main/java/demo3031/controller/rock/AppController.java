package demo3031.controller.rock;

import demo3031.controller.BaseController;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.auth.annotation.AuthRoles;

/**
 * @author noear 2021/6/1 created
 */
@Mapping("/rock/app")
@Controller
public class AppController extends BaseController {
    @Mapping("")
    public void home() {
        //app 首页
    }

    @Mapping("inner")
    public void inner() {
        //内部列表页
    }

    @Mapping("edit/{id}")
    public void edit(int id) {
        //编辑显示页
    }

    @AuthRoles({"admin", "operator"})
    @Mapping("edit/{id}/ajax/save")
    public void save(int id) {
        //编辑处理接口，需要管理员或操作员权限
    }
}
