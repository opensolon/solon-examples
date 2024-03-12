package demo7001.server;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import demo7001.protocol.UserModel;
import demo7001.protocol.UserService;
import org.noear.solon.core.handle.MethodType;

//开启bean的远程服务
@Mapping(path = "/user/")
@Remoting
public class RpcService implements UserService {
    public static void main(String[] args) {
        Solon.start(RpcService.class, args);
    }

    @Override
    public UserModel getUser(Integer userId) {
        UserModel model = new UserModel();
        model.setId(userId);
        model.setName("user-" + userId);

        return model;
    }
}
