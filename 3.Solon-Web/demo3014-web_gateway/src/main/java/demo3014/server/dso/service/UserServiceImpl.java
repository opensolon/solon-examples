package demo3014.server.dso.service;

import demo3014.common.UserModel;
import demo3014.common.UserService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Result;
import demo3014.server.dso.dao.UserDao;

/**
 * @author noear 2021/4/22 created
 */
@Component
public class UserServiceImpl implements UserService {
    @Inject
    UserDao userDao;

    @Override
    public Result<UserModel> getUser() {
        UserModel user = userDao.getUser();

        return Result.succeed(user);
    }
}
