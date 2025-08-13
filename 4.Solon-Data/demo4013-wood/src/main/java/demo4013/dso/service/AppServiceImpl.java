package demo4013.dso.service;

import demo4013.dso.mapper.SqlMapper;
import org.noear.solon.annotation.Managed;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.tran.TranListener;
import org.noear.solon.data.tran.TranPolicy;
import org.noear.solon.data.tran.TranUtils;
import org.noear.wood.annotation.Db;

@Managed
public class AppServiceImpl implements AppService {
    @Db
    SqlMapper sqlMapper1;

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

    @Tran
    @Override
    public void addApp2_2() {
        sqlMapper1.appx_add();

        if(TranUtils.inTrans()) {
            TranUtils.listen(new TranListener() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    System.err.println("---beforeCommit: " + readOnly);
                }

                @Override
                public void afterCompletion(int status) {
                    System.err.println("---afterCompletion: " + status);
                }
            });
        }

        throw new RuntimeException("不让加");
    }

    @Tran(policy = TranPolicy.nested)
    public void addApp3(){
        sqlMapper1.appx_add();
    }

    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp4(){
        sqlMapper1.appx_add();
        return true;
    }

    @Cache(seconds = 10)
    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp52(){
        sqlMapper1.appx_add();
        return true;
    }

    @Cache(seconds = 10)
    @Tran(policy = TranPolicy.requires_new)
    public boolean addApp75(){
        sqlMapper1.appx_add();
        return true;
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
