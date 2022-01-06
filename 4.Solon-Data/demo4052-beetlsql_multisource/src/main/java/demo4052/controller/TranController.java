package demo4052.controller;

import demo4052.dso.service.AppService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Tran;

@Mapping("/tran/")
@Controller
public class TranController {
    @Inject
    AppService appService;

    /**
     * 多数据源时，明确哪个库。。。可增加代码可读性
     * */
    @Tran
    @Mapping("test")
    public void test() throws Exception {
        //添加成功
        //
        appService.addApp();
    }

    @Tran
    @Mapping("test2")
    public void test2() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp();

        throw new RuntimeException("不让你加");
    }
}
