package demo4041.dso.service;

import com.jfinal.plugin.activerecord.Db;
import org.noear.solon.aspect.annotation.Service;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranPolicy;


@Service
public class AppService2 {

    public Object getApp(int app_id) throws Exception {
        return Db.use("db2").template("appx_get2", app_id).findFirst();
        //return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return Db.use("db2").template("appx_get2", Integer.parseInt(app_id)).findFirst();
        //return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran
    public void addApp2(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp4(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
        return true;
    }

    @Cache(seconds = 10)
    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp52(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
        return true;
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6(){
        Db.use("db2").template("appx_add").update();
        //sqlMapper1.appx_add();
    }
}
