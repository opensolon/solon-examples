package client.controller;

import org.noear.solon.cloud.CloudConfigHandler;
import org.noear.solon.cloud.annotation.CloudConfig;
import org.noear.solon.cloud.model.Config;

/**
 * 配置订阅（获取配置的时实刷新）
 *
 * @author luke
 */
@CloudConfig("water_cache_header")
public class TestConfigHandler implements CloudConfigHandler {

    @Override
    public void handle(Config config) {
        System.out.println(config.value());
    }
}
