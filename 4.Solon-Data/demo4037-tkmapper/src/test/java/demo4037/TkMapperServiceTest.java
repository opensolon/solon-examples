package demo4037;

import demo4037.entity.User;
import demo4037.mapper.UserMapper;
import org.apache.ibatis.solon.annotation.Db;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @title: TkMapperServiceTest
 * @author: trifolium.wang
 * @date: 2024/4/3
 */
@SolonTest(TkMapperApplication.class)
@RunWith(SolonJUnit4ClassRunner.class)
public class TkMapperServiceTest {

    @Db("db1")
    private UserMapper userMapper;

    @Test
    public void all() {

        userMapper.selectAll().forEach(System.out::println);
    }

    /**
     * 根据主键查询
     */
    @Test
    public void byId() {

        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    /**
     * 根据example查询
     */
    @Test
    public void exampleQuery() {
        Example example = new Example(User.class);
        example.and().andLike("name", "%张%");
        userMapper.selectByExample(example).forEach(System.out::println);
    }

    /**
     * mybatis 原生查询
     */
    @Test
    public void rawMybatisQuery() {

        userMapper.findByGTAge(11).forEach(System.out::println);
    }

    /**
     * mybatis 逻辑删除和添加,并测试事务
     */
    @Test
    @Rollback
    public void logicDelInsert() {

        List<User> users = userMapper.findByName("张麻子");
        if (!users.isEmpty()) {
            User user = users.get(0);
            userMapper.deleteByPrimaryKey(user.getId());
            user.setId(null);
            userMapper.insert(user);
        }
    }
}
