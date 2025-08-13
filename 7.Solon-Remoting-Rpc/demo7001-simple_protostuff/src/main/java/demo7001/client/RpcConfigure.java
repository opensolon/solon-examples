package demo7001.client;

import org.noear.nami.NamiBuilder;
import org.noear.nami.NamiConfiguration;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.coder.fury.FuryDecoder;
import org.noear.nami.coder.fury.FuryEncoder;
import org.noear.solon.annotation.Managed;

/**
 * @author noear 2023/2/3 created
 */
@Managed
public class RpcConfigure implements NamiConfiguration {
    @Override
    public void config(NamiClient client, NamiBuilder builder) {
        builder.encoder(FuryEncoder.instance);
        builder.decoder(FuryDecoder.instance);
    }
}
