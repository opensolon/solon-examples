package demo9904.server.controller;

import demo9904.protocol.HelloService;
import org.apache.seata.core.context.RootContext;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.sql.SqlUtils;

import java.util.Objects;

/**
 * @author noear 2021/1/8 created
 */
@Mapping("/rpc/")
@Remoting
public class HelloServiceRemoteImp implements HelloService {
    @Inject
    private SqlUtils sqlUtils;

    @Tran
    @Override
    public void insertData(String code) throws Exception {
        System.out.println("remote xid: " + RootContext.getXID());
        this.sqlUtils.sql("insert into demo(code) values(?)", String.format("%s from remote", code)).update();
        if (Objects.equals(code, "remote")) {
            throw new RuntimeException("remote");
        }
    }
}
