package com.example.demo;


import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.solon.annotation.ThriftService;

@ThriftService(serviceName = "UserService")
public class UserServiceImpl implements UserService.Iface {
    @Override
    public User getUser(int id) throws TException {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(18);
        return user;
    }
}
