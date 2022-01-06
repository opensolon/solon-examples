package demo4022.dso.service;

import demo4022.dso.mapper.Appx2Mapper;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.extend.aspect.annotation.Service;

@Service
public class App2Service {
    @Inject
    Appx2Mapper appxMapper2;

    /**
     * 申明使用db2的事务
     * */
    @Tran
    public void add(){
        appxMapper2.appx_add();
    }
}
