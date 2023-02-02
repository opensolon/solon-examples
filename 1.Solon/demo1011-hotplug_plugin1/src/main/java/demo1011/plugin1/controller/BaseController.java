package demo1011.plugin1.controller;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.Render;
import org.noear.solon.view.freemarker.FreemarkerRender;
import org.noear.solon.view.thymeleaf.ThymeleafRender;

/**
 * @author noear 2022/10/8 created
 */
public class BaseController implements Render {
    static final FreemarkerRender viewRenderDef = new FreemarkerRender(BaseController.class.getClassLoader());
    static final ThymeleafRender viewRender2 = new ThymeleafRender(BaseController.class.getClassLoader());

    @Override
    public void render(Object data, Context ctx) throws Throwable {
        if (data instanceof Throwable) {
            throw (Throwable) data;
        }

        if (data instanceof ModelAndView) {
            ModelAndView vm = (ModelAndView) data;
            if (vm.view().endsWith(".html")) {
                viewRender2.render(data, ctx);
            } else {
                viewRenderDef.render(data, ctx);
            }
        } else {
            ctx.render(data);
        }
    }
}
