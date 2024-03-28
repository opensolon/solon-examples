package demoA002.controller.api2;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Gateway;

/**
 * @author noear 2023/6/30 created
 */
@Mapping("/api2/v2/**")
@Component
public class ApiGateway extends Gateway {
    @Override
    protected void register() {
        add(UserApi.class);
        add(UserApiApplicationJson.class);
    }
}
