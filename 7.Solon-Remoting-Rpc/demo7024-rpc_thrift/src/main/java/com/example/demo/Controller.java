package com.example.demo;

import com.example.demo.tutorial.Calculator;
import com.example.demo.tutorial.Operation;
import com.example.demo.tutorial.Work;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.solon.annotation.ThriftClient;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;

@org.noear.solon.annotation.Controller
public class Controller {

    @ThriftClient(serviceName = "UserService")
    private UserService.Client client;

    @ThriftClient(serviceName = "CalculatorHandler")
    private Calculator.Client client2;

    @Mapping("/hello")
    public String hello(@Param(defaultValue = "world") String name) {
        return String.format("Hello %s!", name);
    }

    @Mapping("/test")
    public User test() throws TException {
        return client.getUser(1);
    }

    @Mapping("/test2")
    public int test2() throws TException {
        Work work = new Work();

        work.op = Operation.ADD;
        work.num1 = 1;
        work.num2 = 1;
        return client2.calculate(1, work);
    }
}