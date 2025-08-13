package demo4034.dso.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo4034.dso.mapper.UserMapper;
import demo4034.dso.service.UserService;
import demo4034.model.UserModel;
import lombok.AllArgsConstructor;
import org.noear.solon.annotation.Managed;
import org.noear.solon.data.dynamicds.DynamicDs;

/**
 * @Description: 类作用
 * @Author: csc
 * @Date: 2025/5/1 16:52
 * @Version: 1.0
 **/
@Managed
@AllArgsConstructor
@DynamicDs("db_user_r") //设置数据源
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {
}
