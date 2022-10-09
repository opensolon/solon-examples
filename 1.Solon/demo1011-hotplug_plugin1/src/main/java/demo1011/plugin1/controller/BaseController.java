package demo1011.plugin1.controller;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.Render;
import org.noear.solon.view.freemarker.FreemarkerRender;

/**
 * @author noear 2022/10/8 created
 */
public class BaseController implements Render {
    static final FreemarkerRender viewRender = new FreemarkerRender(BaseController.class.getClassLoader());

    @Override
    public void render(Object data, Context ctx) throws Throwable {
        if(data instanceof Throwable){
            throw (Throwable)data;
        }

        if(data instanceof ModelAndView){
            viewRender.render(data, ctx);
        }else{
            ctx.render(data);
        }
    }
}
