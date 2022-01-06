package demo4022.controller;

import demo4022.dso.mapper.Appx2Mapper;
import demo4022.dso.mapper.AppxMapper;
import demo4022.model.AppxModel;
import org.apache.ibatis.ext.solon.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 注解模式，通过@Db注入，并指定具体的会话工厂
 *
 * @Db 可注入 Mapper, SqlSession, SqlSessionFactory, MybatisProxy
 * */
@Mapping("/demo2/")
@Controller
public class Demo2Controller {
    @Db("db1")
    AppxMapper appxMapper;

    @Db("db2")
    Appx2Mapper appxMapper2;

    @Mapping("test")
    public AppxModel test(){
        return appxMapper.appx_get();
    }

    @Mapping("test2")
    public AppxModel test2(){
        return appxMapper2.appx_get2(48);
    }

}
