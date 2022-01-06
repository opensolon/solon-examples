package demo3011.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Render;

/**
 * 控制器实现Render,即可获取自定义渲染权限；
 *
 * 可以在有需要的控制器上实现；也可以定义一个基类，然后有需要的控制器继承一下
 *
 * @author noear 2020/12/14 created
 */
@Mapping("/render/custom/")
@Controller
public class RenderCustomController implements Render {
    @Override
    public void render(Object data, Context ctx) throws Throwable {
        if (data instanceof RenderCustomController) {
            //你想自己处理的类型，你自己处理；
        } else {
            //不想处理的，交给上下文去处理
            ctx.render(data);
        }
    }

    @Mapping("demo")
    public void demo() {

    }
}
