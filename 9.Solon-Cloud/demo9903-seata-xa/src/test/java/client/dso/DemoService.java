package client.dso;

import demo9903.protocol.HelloService;
import org.apache.seata.core.context.RootContext;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;

import java.util.Objects;

/**
 * @author noear 2020/12/29 created
 */
@Component
public class DemoService {
    //这是本地的
    @Inject
    HelloService localService;

    //这是远程的
    @NamiClient
    HelloService remoteService;

    @GlobalTransactional
    public void insertData(String code) throws Exception {
        System.out.println("xid: " + RootContext.getXID());
        // 先远程调用后本地
        this.remoteService.insertData(code);
        this.localService.insertData(code);

        // 先执行本地后执行远程调用
        // this.localService.insertData(code);
        // this.remoteService.insertData(code);
        if (Objects.equals(code, "insert")) {
            throw new RuntimeException("insert");
        }
    }
}
