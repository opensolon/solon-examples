package demo4051.dso.service;

import demo4051.dso.mapper.SqlMapper;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranPolicy;
import org.noear.solon.annotation.Managed;

@Managed
public class AppService {
    @Db
    SqlMapper sqlMapper1;

    public Object getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        sqlMapper1.appx_add(1);
    }

    @Tran
    public void addApp2(){
        sqlMapper1.appx_add(1);
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3(){
        sqlMapper1.appx_add(1);
    }

    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp4(){
        sqlMapper1.appx_add(1);
        return true;
    }

    @Cache(seconds = 10)
    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp52(){
        sqlMapper1.appx_add(1);
        return true;
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5(){
        sqlMapper1.appx_add(1);
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6(){
        sqlMapper1.appx_add(1);
    }
}
