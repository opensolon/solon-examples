package demo3072;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import reactor.core.publisher.Mono;

@Controller
public class DemoController {
    @Mapping("/hello")
    public Mono<String> hello(String name) {
        return Mono.just("Hello " + name);
    }

    @Mapping("/hello2")
    public Mono<String> hello2(String name) {
        return Mono.create(call -> {
            throw new IllegalStateException("dddd");
        });
    }
}
