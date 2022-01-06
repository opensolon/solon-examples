package demo4022.controller;

import demo4022.dso.mapper.AppxMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Tran;

/**
 * 事务演示
 * */
@Mapping("/tran/")
@Controller
public class TranController {
    @Inject
    AppxMapper appxMapper;

    @Tran
    @Mapping("test")
    public void test() throws Throwable {
        //添加成功
        //
        appxMapper.appx_add();
    }

    @Tran
    @Mapping("test2")
    public void test2() throws Throwable {
        //添加会失败，因为在事务里出异常了
        //
        appxMapper.appx_add();

        throw new RuntimeException("不让你加");
    }
}
