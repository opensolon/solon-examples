package labs;

import org.noear.solon.Solon;

/**
 * @author noear 2024/8/23 created
 */
public class GatewayApp {
    public static void main(String[] args) {
        //指定配置，避免被 app.yml 影响
        Solon.start(GatewayApp.class,  args);
    }
}
