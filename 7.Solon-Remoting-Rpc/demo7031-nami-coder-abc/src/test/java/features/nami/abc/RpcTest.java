package features.nami.abc;

import demo7031.App;
import demo7031.HelloService;
import demo7031.OrderDo;
import org.junit.jupiter.api.Test;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.common.ContentTypes;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2024/12/3 created
 */
@SolonTest(App.class)
public class RpcTest {
    @NamiClient(url = "http://localhost:8080/rpc/hello", headers = {ContentTypes.ABC, ContentTypes.ABC_ACCEPT})
    HelloService helloService;

    @Test
    public void hello() {
        OrderDo orderDo = new OrderDo();
        orderDo.setOrderId(3);

        OrderDo orderDo2 = helloService.hello(orderDo);

        System.out.println(orderDo2);

        assert orderDo2 != null;
        assert orderDo2.getOrderId() == orderDo.getOrderId();
    }
}
