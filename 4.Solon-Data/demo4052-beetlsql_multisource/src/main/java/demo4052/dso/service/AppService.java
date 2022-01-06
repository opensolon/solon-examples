package demo4052.dso.service;

import demo4052.dso.mapper.SqlMapper;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.extend.aspect.annotation.Service;

@Service
public class AppService {
    @Inject
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
