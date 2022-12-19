package demo4061.controller;

import demo4061.model.UserVo;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.extend.sqltoy.annotation.Db;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;

import java.util.List;


@Controller
@Mapping("user")
public class UserController {
    //多数据的时候需要指定dao名称
    //sqlToyLazyDao是默认的数据源
    //单数据用@Inject即可
    @Db
    SqlToyLazyDao dao;

    /**
     * 直接查询列表，其他CRUD请查看sqltoy文档和示例
     * */
    @Mapping("list")
    public Page list(Page page, UserVo query){
      Page<UserVo> users=  dao.findPageBySql(page,"userList",query);
      return users;
    }
}
