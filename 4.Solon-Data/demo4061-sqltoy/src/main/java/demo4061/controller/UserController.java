package demo4061.controller;

import demo4061.model.User;
import demo4061.model.UserVo;
import demo4061.dso.mapper.UserMapper;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
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
    @Db
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
        userMapper.userList("test");
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
    @Mapping("mapper_update")
    public long mapperUpdate(){
        User u=new User();
        u.setUsername("test");
        u.setGender(1);
        return userMapper.updateUser(u);
    }
    @Mapping("mapper_save")
    public User mapperSave(){
        User u=new User();
        u.setUsername("test2");
        u.setGender(1);
        //dao.save(u);
        userMapper.saveUser(u);
        return u;
    }
    @Mapping("mapper_del")
    public long mapperDel(){
//        User u=new User();
//        u.setUsername("test");
//
//        return userMapper.deleteUser(u);
        return userMapper.deleteUser1("test");
    }
}
