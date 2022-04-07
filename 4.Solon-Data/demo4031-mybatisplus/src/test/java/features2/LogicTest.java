package features2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo4031.DemoApp;
import demo4031.dso.mapper.UserMapper;
import demo4031.model.UserModel;
import org.apache.ibatis.ext.solon.Db;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.annotation.Bean;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2022/4/5 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class LogicTest {
    @Db
    UserMapper userMapper;

    @Test
    public void test(){
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setUserId(1L);
        userModel.setNickname("test");
        userModel.setPassword("test");
        userModel.setDeleted(0);

        if(userMapper.selectById(1L) == null) {
            userMapper.insert(userModel);
        }

        userMapper.deleteById(1L);
    }
}
