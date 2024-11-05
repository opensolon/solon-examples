package demo4091.controller;


import demo4091.model.AppxModel;
import demo4091.service.AppService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.sqlink.core.page.PagedResult;

@Mapping("/page/")
@Controller
public class PageController
{
    @Inject
    AppService appService;

    @Mapping("test")
    public Object test() throws Throwable
    {
        PagedResult<AppxModel> pagedResult = appService.appx_get_page();
        return pagedResult.getData();
    }
}
