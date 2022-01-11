package demo4061.controller;

import demo4061.domain.User;
import demo4061.domain.UserVo;
import demo4061.mapper.UserMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;

import java.util.List;


@Controller
@Mapping("user")
public class UserController {
    @Inject
    SqlToyLazyDao dao;
    @Inject
    UserMapper userMapper;

    //直接查询列表，其他CRUD请查看sqltoy文档和示例
    @Mapping("list")
    public Page list(Page page, UserVo query){
      Page<UserVo> users=  dao.findPageBySql(page,"userList",query);
      return users;
    }

    //通过mapper查询一个值
    @Mapping("mapper_one")
    public UserVo mapperOneTest(){
        return userMapper.getByUserName("test");
    }
    //通过mapper查询全部
    @Mapping("mapper_all")
    public List<UserVo> mapperAll(){
        return userMapper.allUser(new UserVo());
    }
    //通过mapper分页查询
    @Mapping("mapper_page")
    public Page<UserVo> mapperPage(Page page){
        return userMapper.pageUser(new UserVo(),page);
    }
    //通过mapper查询统计数据条数
    @Mapping("mapper_count")
    public long mapperCount(){
        return userMapper.count();
    }
}
