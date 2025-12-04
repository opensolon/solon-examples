package demo9074.server.dso.service;

import org.noear.solon.annotation.Managed;
import org.noear.solon.cloud.telemetry.annotation.Tracing;

/**
 * @author noear 2022/5/7 created
 */
@Managed
public class UserService extends BaseService{
    @Tracing(name = "获取用户", tags = "用户=#{name}")
    public String getUser(String name) {
        return name;
    }


    public String updateUser(String name){
        return name;
    }
}
