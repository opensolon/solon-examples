package demo4021.dso.service;

import demo4021.dso.mapper.AppxMapper;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranPolicy;
import org.noear.solon.annotation.Managed;

@Managed
public class AppService {
    @Db
    AppxMapper sqlMapper1;

    public Object getApp(int app_id) throws Exception {
        return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        sqlMapper1.appx_add();
    }

    @Tran
    public void addApp2(){
        sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3(){
        sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp32(){
        sqlMapper1.appx_add();

        throw new RuntimeException("不让你加");
    }

    @Tran(policy = TranPolicy.requires_new)
    public void addApp4(){
        sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5(){
        sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6(){
        sqlMapper1.appx_add();
    }
}
