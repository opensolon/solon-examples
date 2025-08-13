package features.nami.protostuff;

import demo7032.App;
import demo7032.HelloService;
import demo7032.MessageDo;
import org.junit.jupiter.api.Test;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.common.ContentTypes;
import org.noear.solon.annotation.Managed;
import org.noear.solon.net.http.HttpUtils;
import org.noear.solon.serialization.protostuff.ProtostuffBytesSerializer;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2024/12/3 created
 */
@Managed
@SolonTest(App.class)
public class RpcTest {
    @NamiClient(url = "http://localhost:8080/rpc/demo", headers = {ContentTypes.PROTOBUF, ContentTypes.PROTOBUF_ACCEPT})
    HelloService helloService;

    @Test
    public void nami() {
        MessageDo messageDo = new MessageDo();
        messageDo.setId(3);

        MessageDo messageDo1 = helloService.hello(messageDo);

        System.out.println(messageDo1);

        assert messageDo1 != null;
        assert messageDo1.getId() == messageDo.getId();
    }

    @Test
    public void http() throws IOException {
        MessageDo messageDo = new MessageDo();
        messageDo.setId(3);

        MessageDo messageDo1 = HttpUtils.http("http://localhost:8080/rpc/demo/hello")
                .serializer(ProtostuffBytesSerializer.getInstance())
                .header(ContentTypes.HEADER_CONTENT_TYPE, ContentTypes.PROTOBUF_VALUE)
                .header(ContentTypes.HEADER_ACCEPT, ContentTypes.PROTOBUF_VALUE)
                .bodyOfBean(messageDo)
                .postAs(MessageDo.class);


        System.out.println(messageDo1);

        assert messageDo1 != null;
        assert messageDo1.getId() == messageDo.getId();
    }
}
