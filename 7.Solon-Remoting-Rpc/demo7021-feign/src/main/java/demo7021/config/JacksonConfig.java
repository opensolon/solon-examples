package demo7021.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.solon.FeignClient;
import feign.solon.FeignConfiguration;

public class JacksonConfig implements FeignConfiguration {
    @Override
    public Feign.Builder config(FeignClient client, Feign.Builder builder) {
        return builder.encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder());
    }
}
