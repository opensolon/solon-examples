package demo7006.server.controller;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import demo7006.server.dso.IGreetingService;

import java.io.IOException;

@Mapping("/GreetingService/")
@Remoting
public class GreetingService implements IGreetingService {
    @Override
    public String greeting(String name) throws IOException {
        return "Welcome ot the Hassian world, " + name;
    }
}
