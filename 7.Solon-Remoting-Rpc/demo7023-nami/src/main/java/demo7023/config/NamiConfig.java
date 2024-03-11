package demo7023.config;


import org.noear.nami.NamiBuilder;
import org.noear.nami.NamiConfiguration;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.coder.snack3.SnackDecoder;
import org.noear.nami.coder.snack3.SnackEncoder;
import org.noear.solon.annotation.Component;

@Component
public class NamiConfig implements NamiConfiguration {
    @Override
    public void config(NamiClient client, NamiBuilder builder) {
        builder.encoder(new SnackEncoder())
                .decoder(new SnackDecoder());
    }
}
