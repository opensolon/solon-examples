package demo4091.service;

import demo4091.model.AppxModel;
import demo4091.model.Test;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.sqlink.SqLink;
import org.noear.solon.data.sqlink.core.dialect.H2Dialect;
import org.noear.solon.data.sqlink.core.page.PagedResult;
import org.noear.solon.data.sqlink.core.sqlExt.SqlFunctions;
import org.noear.solon.data.tran.TranPolicy;

import java.util.List;

@Component
public class AppService {
    @Inject
    SqLink client;

    public boolean any() {
        return client.query(AppxModel.class).any();
    }

    public String hello(String name) {
        return client.queryEmptyTable().endSelect(() ->
                SqlFunctions.join(" ", "hello", name)).first();
    }

    public PagedResult<AppxModel> appx_get_page() {
        return client.query(AppxModel.class).toPagedResult(2, 2);
    }

    //select * from appx limit 1;
    public AppxModel getOne() {
        return client.query(AppxModel.class).first();
    }

    //select * from appx as a where a.app_id = 1 limit 1;
    public AppxModel getOneById(int id) {
        return client.query(AppxModel.class).where(a -> a.getAppId() == id).first();
    }

    public List<AppxModel> getAll() {
        return client.query(AppxModel.class).toList();
    }

    public List<Test> getAllTest() {
        return client.query(Test.class).toList();
    }

    //insert into test (v1) values (1024)
    public void addApp() {
        Test test = new Test();
        test.setV1(1024);
        client.insert(test).executeRows();
    }

    public long appx_add2(int v1) {
        Test test = new Test();
        test.setV1(v1);
        return client.insert(test).executeRows();
    }

    public Test getTestByV1(int v1) {
        return client.query(Test.class)
                .where(a -> a.getV1() == v1)
                .first();
    }

    @Tran
    public void addApp2() {
        addApp();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3() {
        addApp();
    }

    @Tran(policy = TranPolicy.requires_new)
    public void addApp4() {
        addApp();
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5() {
        addApp();
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6() {
        addApp();
    }


}
