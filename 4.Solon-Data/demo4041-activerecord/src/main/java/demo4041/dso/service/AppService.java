package demo4041.dso.service;

import com.jfinal.plugin.activerecord.DbPro;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranPolicy;
import org.noear.solon.aspect.annotation.Service;
import org.noear.solon.extend.activerecord.annotation.Db;


@Service
public class AppService {
    //测试注入
    @Db
    DbPro db1;

    public Object getApp(int app_id) throws Exception {
        return db1.template("appx_get2", app_id).findFirst();
        //return sqlMapper1.appx_get2(app_id);
    }

    public Object getApp(String app_id) throws Exception {
        return db1.template("appx_get2", Integer.parseInt(app_id)).findFirst();
        //return sqlMapper1.appx_get2(Integer.parseInt(app_id));
    }

    public void addApp(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran
    public void addApp2(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp4(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
        return true;
    }

    @Cache(seconds = 10)
    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp52(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
        return true;
    }

    @Tran(policy = TranPolicy.never)
    public void addApp5(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.mandatory)
    public void addApp6(){
        db1.template("appx_add").update();
        //sqlMapper1.appx_add();
    }
}
