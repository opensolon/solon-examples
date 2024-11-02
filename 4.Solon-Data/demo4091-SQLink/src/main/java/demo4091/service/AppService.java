package demo4091.service;

import demo4091.model.AppxModel;
import demo4091.model.DbTable;
import demo4091.model.Test;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.data.sqlink.core.api.client.Client;
import org.noear.solon.data.tran.TranPolicy;

import java.util.List;

@Component
public class AppService
{
    @Inject
    Client client;

    @Inject
    SqlUtils sqlUtils;

    public List<? extends DbTable> listTables()
    {
        return client.query(DbTable.class).toList();
    }

    //select * from appx limit 1;
    public AppxModel getOne()
    {
        return client.query(AppxModel.class).first();
    }

    //select * from appx as a where a.app_id = 1 limit 1;
    public AppxModel getOneById(int id)
    {
        return client.query(AppxModel.class).where(a -> a.getAppId() == id).first();
    }

    public List<? extends AppxModel> getAll()
    {
        return client.query(AppxModel.class).toList();
    }

    public List<? extends Test> getAllTest()
    {
        return client.query(Test.class).toList();
    }

    //insert into test (v1) values (1024)
    public void addApp()
    {
        Test test = new Test();
        test.setV1(1024);
        client.insert(test).executeRows();
    }

    public long appx_add2(int v1)
    {
        Test test = new Test();
        test.setV1(v1);
        return client.insert(test).executeRows();
    }

    @Tran
    public void addApp2()
    {
        addApp();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3()
    {
        addApp();
    }

    @Tran(policy = TranPolicy.requires_new)
    public void addApp4()
    {
        addApp();
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5()
    {
        addApp();
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6()
    {
        addApp();
    }
}
