package demo3072;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Render;
import reactor.core.publisher.Mono;

@Controller
public class DemoController implements Render {
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

    @Mapping("/hello3")
    public Mono<Void> hello3(Context ctx,String name) {
        return Mono.empty();
    }

    @Override
    public void render(Object data, Context ctx) throws Throwable {
        if (data instanceof Throwable) {
            ctx.render("出错了：" + ((Throwable) data).getMessage());
        } else {
            ctx.render(data);
        }
    }
}
