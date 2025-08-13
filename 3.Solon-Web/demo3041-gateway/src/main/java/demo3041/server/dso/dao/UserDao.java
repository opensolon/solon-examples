package demo3041.server.dso.dao;

import demo3041.common.UserModel;
import org.noear.solon.annotation.Managed;

/**
 * @author noear 2021/4/22 created
 */
@Managed
public class UserDao {

    public UserModel getUser() {
        UserModel user = new UserModel();
        user.setUserId(12);
        user.setNickname("noear");

        return user;
    }
}
