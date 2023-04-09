package demo7006.client.dso;


import org.noear.nami.NamiBuilder;
import org.noear.nami.NamiConfiguration;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.coder.jackson.JacksonTypeEncoder;

import java.util.function.Supplier;

public class FairyConfigurationImp implements NamiConfiguration {
    private Supplier<String> test = () -> "http://localhost:8080";

    @Override
    public void config(NamiClient client, NamiBuilder builder) {
        builder.encoder(JacksonTypeEncoder.instance);
        builder.upstream(test);
    }
}
