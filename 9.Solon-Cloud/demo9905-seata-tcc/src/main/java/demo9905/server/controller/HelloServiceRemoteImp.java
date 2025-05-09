package demo9905.server.controller;

import demo9905.constant.RemoteAppCtx;
import demo9905.protocol.HelloService;
import org.apache.seata.core.context.RootContext;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.rm.tcc.api.BusinessActionContextParameter;
import org.apache.seata.rm.tcc.api.TwoPhaseBusinessAction;
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
    @TwoPhaseBusinessAction(name = "RemoteTccActionTwo", commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepare(BusinessActionContext actionContext, @BusinessActionContextParameter(paramName = "code") String code) throws Exception {
        RemoteAppCtx.PREPARE = true;
        System.out.println("remote xid: " + RootContext.getXID());
        this.sqlUtils.sql("insert into demo(code) values(?)", String.format("%s from remote", code)).update();
        if (Objects.equals(code, "remote")) {
            throw new RuntimeException("remote");
        }
        return true;
    }

    public boolean commit(BusinessActionContext actionContext) {
        RemoteAppCtx.COMMIT = true;
        System.out.println("remote commit call");
        return true;
    }

    public boolean rollback(BusinessActionContext actionContext) {
        System.out.println("remote commit rollback");
        RemoteAppCtx.ROLLBACK = true;
        return true;
    }

    @Override
    public boolean getCommitExeStatus() {
        return RemoteAppCtx.COMMIT;
    }

    @Override
    public boolean getRollbackExeStatus() {
        return RemoteAppCtx.ROLLBACK;
    }

    @Override
    public boolean getPrepareExeStatus() {
        return RemoteAppCtx.PREPARE;
    }

    @Override
    public void init() {
        RemoteAppCtx.init();
    }
}
