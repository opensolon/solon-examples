package features.nami.abc;

import demo7031.App;
import demo7031.HelloService;
import demo7031.MessageDo;
import org.junit.jupiter.api.Test;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.common.ContentTypes;
import org.noear.solon.net.http.HttpUtils;
import org.noear.solon.serialization.abc.AbcBytesSerializer;
import org.noear.solon.test.SolonTest;

import java.io.IOException;

/**
 * @author noear 2024/12/3 created
 */
@SolonTest(App.class)
public class RpcTest {
    @NamiClient(url = "http://localhost:8080/rpc/demo", headers = {ContentTypes.ABC, ContentTypes.ABC_ACCEPT})
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
                .serializer(AbcBytesSerializer.getInstance())
                .header(ContentTypes.HEADER_CONTENT_TYPE, ContentTypes.ABC_VALUE)
                .header(ContentTypes.HEADER_ACCEPT, ContentTypes.ABC_VALUE)
                .bodyOfBean(messageDo)
                .postAs(MessageDo.class);


        System.out.println(messageDo1);

        assert messageDo1 != null;
        assert messageDo1.getId() == messageDo.getId();
    }
}
