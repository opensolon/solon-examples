package demo4072.controller;

import demo4072.dso.mapper.AppxMapper;
import demo4072.model.Appx;
import net.hasor.dbvisitor.jdbc.core.JdbcTemplate;
import net.hasor.dbvisitor.lambda.LambdaTemplate;
import net.hasor.dbvisitor.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 分包模式，一开始就被会话工厂mapperScan()并关联好了
 * */
@Mapping("/demo/")
@Controller
public class DemoController {
    @Db
    AppxMapper appxMapper;

    @Db
    JdbcTemplate jdbcTemplate;

    @Db
    LambdaTemplate lambdaTemplate;

    @Mapping("test")
    public Appx test(){

        //jdbcTemplate.queryForMap("select * from appx where id=1");
        return appxMapper.appx_get();
    }

}
