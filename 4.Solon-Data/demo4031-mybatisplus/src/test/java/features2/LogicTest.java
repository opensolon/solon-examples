package features2;

import demo4031.DemoApp;
import demo4031.dso.mapper.AppxMapper;
import demo4031.dso.mapper.UserMapper;
import demo4031.dso.service.TestService;
import demo4031.model.AppxModel;
import demo4031.model.UserModel;
import org.apache.ibatis.solon.annotation.Db;
import org.junit.jupiter.api.Test;

import org.noear.solon.annotation.Inject;

import org.noear.solon.test.SolonTest;

/**
 * @author noear 2022/4/5 created
 */

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


    @Inject
    TestService testService;

    @Test
    public void test2() throws Exception{
       assert  testService.getApp(1).getAppId() == 1;
    }
}
