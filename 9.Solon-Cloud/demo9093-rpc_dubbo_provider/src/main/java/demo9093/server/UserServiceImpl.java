package demo9093.server;

import demo9093.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String name) {
        return name;
    }
}
