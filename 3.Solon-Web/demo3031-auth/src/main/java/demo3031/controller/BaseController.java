package demo3031.controller;

import demo3031.dso.Session;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Singleton;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.validation.annotation.Valid;

/**
 * @author noear 2022/1/6 created
 */
@Valid
@Singleton(false)
public class BaseController {
    /*视图数据模型*/
    protected ModelAndView viewModel = new ModelAndView();

    /*
     * @return 输出一个视图（自动放置viewModel）
     * @param viewName 视图名字(内部uri)
     * */
    public ModelAndView view(String viewName) {
        //设置公共参数
        viewModel.put("app", Solon.cfg().appTitle());

        viewModel.put("css", "/_static/css");
        viewModel.put("js", "/_static/js");
        viewModel.put("img", "/_static/img");
        viewModel.put("title", Solon.cfg().appTitle());


        //设置当前用户信息
        viewModel.put("user_id", Session.current().getSubjectId());
        viewModel.put("user_display_name", Session.current().getDisplayName());


        return viewModel.view(viewName + ".ftl");
    }
}
