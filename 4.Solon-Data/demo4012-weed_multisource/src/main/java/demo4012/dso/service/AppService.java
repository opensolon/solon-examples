package demo4012.dso.service;

import demo4012.dso.mapper.SqlMapper;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.aspect.annotation.Service;
import org.noear.weed.annotation.Db;

@Service
public class AppService {
    @Db
    SqlMapper sqlMapper1;

    @Tran
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
}
