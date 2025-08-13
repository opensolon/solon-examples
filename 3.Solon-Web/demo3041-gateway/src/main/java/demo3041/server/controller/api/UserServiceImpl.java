package demo3041.server.controller.api;

import demo3041.common.UserModel;
import demo3041.common.UserService;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;
import demo3041.server.dso.dao.UserDao;

/**
 * @author noear 2021/4/22 created
 */
@Managed
public class UserServiceImpl implements UserService {
    @Inject
    UserDao userDao;

    @Override
    public UserModel getUser() {
        UserModel user = userDao.getUser();

        return user;
    }
}
