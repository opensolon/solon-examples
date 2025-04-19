package client.dso;

import client.constant.LocalAppCtx;
import demo9905.protocol.HelloService;
import org.apache.seata.core.context.RootContext;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.rm.tcc.api.LocalTCC;
import org.apache.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.sql.SqlUtils;

import java.util.Objects;

/**
 * @author noear 2020/12/29 created
 */
@LocalTCC
@Component
public class HelloServiceLocalImp implements HelloService {
    @Inject
    private SqlUtils sqlUtils;

    @Tran
    @Override
    @TwoPhaseBusinessAction(name = "LocalTccActionTwo", commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepare(BusinessActionContext actionContext, String code) throws Exception {
        System.out.println("local xid: " + RootContext.getXID());
        LocalAppCtx.PREPARE = true;
        this.sqlUtils.sql("insert into demo(code) values(?)", String.format("%s from local", code)).update();
        if (Objects.equals(code, "local")) {
            throw new RuntimeException("local");
        }
        return true;
    }

    @Override
    public boolean getCommitExeStatus() {
        return LocalAppCtx.COMMIT;
    }

    @Override
    public boolean getRollbackExeStatus() {
        return LocalAppCtx.ROLLBACK;
    }

    @Override
    public boolean getPrepareExeStatus() {
        return LocalAppCtx.PREPARE;
    }

    @Override
    public void init() {
        LocalAppCtx.init();
    }

    public boolean commit(BusinessActionContext actionContext) {
        System.out.println("local commit call");
        LocalAppCtx.COMMIT = true;
        return true;
    }

    public boolean rollback(BusinessActionContext actionContext) {
        System.out.println("local commit rollback");
        LocalAppCtx.ROLLBACK = true;
        return true;
    }
}
