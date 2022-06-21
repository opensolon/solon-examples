package demo4022.dso.service;

import demo4022.dso.mapper.AppxMapper;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.aspect.annotation.Service;

@Service
public class AppService {
    @Inject
    AppxMapper appxMapper;

    /**
     * 申明使用db1的事务
     * */
    @Tran
    public void add(){
        appxMapper.appx_add();
    }
}
