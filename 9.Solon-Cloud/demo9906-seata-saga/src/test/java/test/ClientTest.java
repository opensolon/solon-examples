package test;

import demo9906.ServarApp;
import org.apache.seata.saga.engine.AsyncCallback;
import org.apache.seata.saga.engine.StateMachineEngine;
import org.apache.seata.saga.proctrl.ProcessContext;
import org.apache.seata.saga.statelang.domain.ExecutionStatus;
import org.apache.seata.saga.statelang.domain.StateMachineInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2021/1/18 created
 */

@SolonTest(ServarApp.class)
public class ClientTest extends HttpTester {

    private static final Object LOCK = new Object();
    private static final AsyncCallback CALL_BACK = new AsyncCallback() {
        @Override
        public void onFinished(ProcessContext context, StateMachineInstance stateMachineInstance) {
            synchronized (LOCK) {
                LOCK.notifyAll();
            }
        }

        @Override
        public void onError(ProcessContext context, StateMachineInstance stateMachineInstance, Exception exp) {
            synchronized (LOCK) {
                LOCK.notifyAll();
            }
        }
    };
    @Inject
    private SqlUtils sqlUtils;
    @Inject
    private StateMachineEngine stateMachineEngine;

    private static void waitingForFinish(StateMachineInstance inst) {
        synchronized (LOCK) {
            if (ExecutionStatus.RU.equals(inst.getStatus())) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted");
                    e.printStackTrace();
                }
            }
        }
    }

    private void transactionCommittedDemo() {

        Map<String, Object> startParams = new HashMap<>(3);
        String businessKey = String.valueOf(System.currentTimeMillis());
        startParams.put("businessKey", businessKey);
        startParams.put("count", 10);
        startParams.put("amount", new BigDecimal("100"));

        //sync test
        StateMachineInstance inst = this.stateMachineEngine.startWithBusinessKey("reduceInventoryAndBalance", null,
                businessKey, startParams);

        isTrue(ExecutionStatus.SU.equals(inst.getStatus()),
                "saga transaction execute failed. XID: " + inst.getId());
        System.out.println("saga transaction commit succeed. XID: " + inst.getId());

        inst = stateMachineEngine.getStateMachineConfig().getStateLogStore().getStateMachineInstanceByBusinessKey(
                businessKey, null);
        isTrue(ExecutionStatus.SU.equals(inst.getStatus()),
                "saga transaction execute failed. XID: " + inst.getId());

        //async test
        businessKey = String.valueOf(System.currentTimeMillis());
        inst = stateMachineEngine.startWithBusinessKeyAsync("reduceInventoryAndBalance", null, businessKey, startParams,
                CALL_BACK);

        waitingForFinish(inst);

        isTrue(ExecutionStatus.SU.equals(inst.getStatus()),
                "saga transaction execute failed. XID: " + inst.getId());

        System.out.println("saga transaction commit succeed. XID: " + inst.getId());
    }

    private void transactionCompensatedDemo() {
        Map<String, Object> startParams = new HashMap<>(4);
        String businessKey = String.valueOf(System.currentTimeMillis());
        startParams.put("businessKey", businessKey);
        startParams.put("count", 10);
        startParams.put("amount", new BigDecimal("100"));
        startParams.put("mockReduceBalanceFail", "true");

        //async test
        businessKey = String.valueOf(System.currentTimeMillis());
        StateMachineInstance inst = this.stateMachineEngine.startWithBusinessKeyAsync("reduceInventoryAndBalance", null, businessKey, startParams,
                CALL_BACK);

        waitingForFinish(inst);

        isTrue(ExecutionStatus.SU.equals(inst.getCompensationStatus()),
                "saga transaction compensate failed. XID: " + inst.getId());

        System.out.println("saga transaction compensate succeed. XID: " + inst.getId());
    }

    private void isTrue(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException(message);
        }
    }

    @BeforeEach
    public void before() throws SQLException, IOException {
        this.sqlUtils.initDatabase("classpath:db.sql");
        this.sqlUtils.sql("delete from demo").update();
    }

    @Test
    public void test() throws Exception {
        transactionCommittedDemo();
        transactionCompensatedDemo();
    }
}
