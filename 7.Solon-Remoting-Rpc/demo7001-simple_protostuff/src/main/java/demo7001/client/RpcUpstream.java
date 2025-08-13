package demo7001.client;

import org.noear.solon.annotation.Managed;
import org.noear.solon.core.LoadBalance;

/**
 * 定义一个负载器（可以对接发现服务）
 * */
@Managed("local")
public class RpcUpstream implements LoadBalance {
    @Override
    public String getServer(int port) {
        return "http://localhost:8080";
    }
}
