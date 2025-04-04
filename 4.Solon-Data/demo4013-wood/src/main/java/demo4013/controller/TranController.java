package demo4013.controller;

import demo4013.dso.service.AppService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.annotation.TranAnno;
import org.noear.solon.data.tran.TranUtils;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

@Mapping("/tran/")
@Controller
public class TranController {
    @Inject
    AppService appService;

    @Cache
    @Tran
    @Mapping("test0")
    public String test0() throws Exception {
        //添加会成功
        //
        appService.addApp();
        appService.addApp();
        return "OK";
    }

    @Tran
    @Mapping("test")
    public void test() throws Exception {
        //添加会成功
        //
        appService.addApp();
        appService.addApp();
    }

    @Tran
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

    @Tran
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

    @Mapping("test12_2")
    public void test12_2() throws Exception {
        //添加会成功
        //
        appService.addApp2_2();
    }

    @Tran
    @Mapping("test21")
    public void test21() throws Exception {
        appService.addApp2();
    }

    @Tran
    @Mapping("test22")
    public void test22() throws Exception {
        //添加会失败，因为在事务里出异常了
        //
        appService.addApp2();

        throw new RuntimeException("不让你加");
    }


    @Tran
    @Mapping("test41")
    public void test41(int nt) throws Exception {
        //添加会成功
        //
        appService.addApp3();

        if (nt == 0) {
            throw new RuntimeException("不让你加");
        }
    }

    @Db
    DbContext db;

    @Tran
    @Mapping("test42")
    public void test42(int nt) throws Exception {
        //添加会成功
        //
        db.exe("insert into test (v1) values (1024);");

        if (nt == 0) {
            throw new RuntimeException("不让你加");
        }
    }


    @Tran
    @Mapping("test51")
    public void test51() throws Exception {
        //添加会成功，因为addApp4是独立的新事务
        //
        appService.addApp4();

        throw new RuntimeException("不让你加，但还是成功了：（");
    }

    @Tran
    @Mapping("test52")
    public boolean test52() throws Exception {
        //添加会成功，因为addApp4是独立的新事务
        //
        appService.addApp52();
        return true;
    }

    @Tran
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

    @Tran
    @Mapping("test71")
    public void test71() throws Exception {
        //会成功
        //
        appService.addApp6();

    }

    @Mapping("test71_2")
    public void test71_2() throws Throwable {
        //会成功
        //
        TranUtils.execute(new TranAnno(), () -> {
            appService.addApp6();
        });
    }

    @Mapping("test73")
    public void test73() throws Exception {
        //会失败
        //
        appService.addApp6();
    }

    @Tran(readOnly = true)
    @Mapping("test74")
    public void test74() throws Exception {
        //会失败
        //
        appService.addApp();
    }

    @Mapping("test74_2")
    public void test74_2() throws Throwable {
        //会失败
        //
        TranUtils.execute(new TranAnno().readOnly(true), () -> {
            appService.addApp();
        });

    }

    @Tran(readOnly = true)
    @Mapping("test75")
    public void test75() throws Exception {
        //会成功
        //
        appService.addApp75();
        //会失败
        //
        appService.addApp();
    }
}
