package demo4041.dso.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbPro;
import org.noear.solon.annotation.Managed;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranPolicy;


@Managed
public class AppService2 {

    //测试注入
    @com.jfinal.plugin.activerecord.solon.annotation.Db("db2")
    DbPro db2;

    public Object getApp(int app_id) throws Exception {
        return Db.use("db2").template("appx_get2", app_id).findFirst();
        //return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return Db.use("db2").template("appx_get2", Integer.parseInt(app_id)).findFirst();
        //return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran
    public void addApp2(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp4(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
        return true;
    }

    @Cache(seconds = 10)
    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp52(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
        return true;
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6(){
        db2.template("appx_add").update();
        //sqlMapper1.appx_add();
    }
}
