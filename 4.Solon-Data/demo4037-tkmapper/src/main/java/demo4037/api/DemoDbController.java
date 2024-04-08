package demo4037.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo4037.entity.User;
import demo4037.mapper.UserMapper;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;
import org.noear.solon.validation.annotation.Valid;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @title: DemoDbController
 * @author: trifolium.wang
 * @date: 2024/4/2
 */
@Valid
@Controller
@Mapping("/tk")
public class DemoDbController {

    @Db("db1")
    private UserMapper userMapper;

    @Get
    @Mapping("/orm1")
    public User dbTest1(@Param("id") Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Get
    @Mapping("/orm2")
    public PageInfo<User> dbTest2() {
        try (Page<Object> page = PageHelper.startPage(1, 10)) {
            PageInfo<User> pageInfo = page.doSelectPageInfo(() -> userMapper.selectAll());
            return pageInfo;
        }
    }

    @Get
    @Mapping("/orm3")
    public List<User> dbTest3() {
        Example example = new Example(User.class);
        example.and().andLike("name", "%张%");
        return userMapper.selectByExample(example);
    }

    @Get
    @Mapping("/orm4")
    public List<User> logicDelAndInsert() {

        List<User> users = userMapper.findByName("张麻子");
        if (!users.isEmpty()) {
            User user = users.get(0);

            // 删除
            userMapper.deleteByPrimaryKey(user.getId());
            user.setId(null);

            // 插入一个新的
            userMapper.insert(user);
        }

        // id变了
        return userMapper.findByName("张麻子");
    }
}
