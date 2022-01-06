package demo3014.common;

import org.noear.solon.core.handle.Result;

/**
 * @author noear 2021/4/22 created
 */
public interface UserService {
    Result<UserModel> getUser();
}
