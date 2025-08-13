package client.dso;

import demo9903.protocol.HelloService;
import org.apache.seata.core.context.RootContext;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.sql.SqlUtils;

import java.util.Objects;

/**
 * @author noear 2020/12/29 created
 */
@Managed
public class HelloServiceLocalImp implements HelloService {
    @Inject
    private SqlUtils sqlUtils;

    @Tran
    @Override
    public void insertData(String code) throws Exception {
        System.out.println("local xid: " + RootContext.getXID());
        this.sqlUtils.sql("insert into demo(code) values(?)", String.format("%s from local", code)).update();
        if (Objects.equals(code, "local")) {
            throw new RuntimeException("local");
        }
    }
}
