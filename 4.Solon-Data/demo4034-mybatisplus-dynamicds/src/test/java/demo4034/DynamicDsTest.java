package demo4034;

import demo4034.dso.service.UserService;
import demo4034.dso.service.UserService2;
import demo4034.model.UserModel;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;

import java.util.List;

/**
 * @Description: 类作用
 * @Author: csc
 * @Date: 2025/5/1 16:57
 * @Version: 1.0
 **/
@SolonTest
public class DynamicDsTest {

    @Inject
    private UserService userService;


    @Inject
    private UserService2 userService2;


    @Test
    public void  ceshi(){
        List<UserModel> list = userService.list();
        List<UserModel> list2 = userService2.list();
        list.forEach(System.out::println);
        list2.forEach(System.out::println);
    }

}
