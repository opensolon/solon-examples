package demo9021.protocol;

import org.noear.nami.annotation.NamiClient;

/**
 * 在接口上添加NamiClient申明，主要是为了在使用时，不需要到处写配置
 *
 * ::helloapi  表示后端服务名
 * ::/rpc/ 表示资源路径
 *
 * @author noear 2020/12/29 created
 */
@NamiClient(name = "helloapi",path = "/rpc/")
public interface HelloService {
    String hello();
}
