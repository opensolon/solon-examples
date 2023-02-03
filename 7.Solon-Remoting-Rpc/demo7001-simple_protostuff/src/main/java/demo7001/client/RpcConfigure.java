package demo7001.client;

import org.noear.nami.NamiBuilder;
import org.noear.nami.NamiConfiguration;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.coder.protostuff.ProtostuffDeoder;
import org.noear.nami.coder.protostuff.ProtostuffEncoder;
import org.noear.solon.annotation.Component;

/**
 * @author noear 2023/2/3 created
 */
@Component
public class RpcConfigure implements NamiConfiguration {
    @Override
    public void config(NamiClient client, NamiBuilder builder) {
        builder.encoder(ProtostuffEncoder.instance);
        builder.decoder(ProtostuffDeoder.instance);
    }
}
