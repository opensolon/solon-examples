package demo7012.server;

import demo7012.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String name) {
        return name;
    }
}
