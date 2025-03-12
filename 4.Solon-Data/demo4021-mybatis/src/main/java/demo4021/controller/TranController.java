package demo4021.controller;

import demo4021.dso.service.AppService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Transaction;

@Mapping("/tran/")
@Controller
public class TranController {
    @Inject
    AppService appService;

    @Transaction
    @Mapping("test")
    public void test() throws Exception {
        //添加会成功
        //
        appService.addApp();
        appService.addApp();
    }

    @Transaction
    @Mapping("test2")
    public void test2() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp();
        appService.addApp();

        throw new RuntimeException("不让你加");
    }

    @Inject
    TranController self;

    @Transaction
    public void test2_2_do() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp();
        appService.addApp();

        throw new RuntimeException("不让你加");
    }

    @Mapping("test2_2")
    public void test2_2() throws Exception {
        self.test2_2_do();
    }

    @Mapping("test11")
    public void test11() throws Exception {
        //添加会成功
        //
        appService.addApp2();
    }

    @Mapping("test12")
    public void test12() throws Exception {
        //添加会成功（因为异常在事务之外） // addApp2 有事务
        //
        appService.addApp2();

        throw new RuntimeException("不让你加；但还是加了:(");
    }

    @Transaction
    @Mapping("test21")
    public void test21() throws Exception {
        appService.addApp2();
    }

    @Transaction
    @Mapping("test22")
    public void test22() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp2();

        throw new RuntimeException("不让你加");
    }

    @Transaction
    @Mapping("test41")
    public void test41() throws Exception {
        //会失败（因为事务内嵌受父级托管理）
        //
        appService.addApp3();

        throw new RuntimeException("不让你加");
    }

    @Transaction
    @Mapping("test42")
    public void test42() throws Exception {
        //添加会成功
        appService.addApp();

        try {
            appService.addApp32();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transaction
    @Mapping("test51")
    public void test51() throws Exception {
        //添加会成功，因为addApp4是独立的新事务
        //
        appService.addApp4();

        throw new RuntimeException("不让你加，但还是成功了：（");
    }

    @Transaction
    @Mapping("test61")
    public void test61() throws Exception {
        //会失败
        //
        appService.addApp5();

    }


    @Mapping("test63")
    public void test63() throws Exception {
        //添加会成功
        //
        appService.addApp5();
    }

    @Transaction
    @Mapping("test71")
    public void test71() throws Exception {
        //会成功
        //
        appService.addApp6();

    }

    @Mapping("test73")
    public void test73() throws Exception {
        //会失败
        //
        appService.addApp6();
    }
}
