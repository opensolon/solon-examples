package features.nami.protostuff;

import demo7032.App;
import demo7032.HelloService;
import demo7032.OrderDo;
import org.junit.jupiter.api.Test;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.common.ContentTypes;
import org.noear.solon.net.http.HttpUtils;
import org.noear.solon.serialization.protostuff.ProtostuffBytesSerializer;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2024/12/3 created
 */
@SolonTest(App.class)
public class RpcTest {
    @NamiClient(url = "http://localhost:8080/rpc/hello", headers = {ContentTypes.PROTOBUF})
    HelloService helloService;

    @Test
    public void nami() {
        OrderDo orderDo = new OrderDo();
        orderDo.setOrderId(3);

        OrderDo orderDo2 = helloService.hello(orderDo);

        System.out.println(orderDo2);

        assert orderDo2 != null;
        assert orderDo2.getOrderId() == orderDo.getOrderId();
    }

    @Test
    public void http() throws IOException {
        OrderDo orderDo = new OrderDo();
        orderDo.setOrderId(3);

        OrderDo orderDo2 = HttpUtils.http("http://localhost:8080/rpc/hello/hello")
                .serializer(ProtostuffBytesSerializer.getInstance())
                .header(ContentTypes.HEADER_CONTENT_TYPE, ContentTypes.PROTOBUF_VALUE)
                .header(ContentTypes.HEADER_ACCEPT, ContentTypes.PROTOBUF_VALUE)
                .bodyOfBean(orderDo)
                .postAs(OrderDo.class);


        System.out.println(orderDo2);

        assert orderDo2 != null;
        assert orderDo2.getOrderId() == orderDo.getOrderId();
    }
}
