package demo1092;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;

/**
 * @author noear 2024/3/25 created
 */
@Managed
public class VertxHttpVerticle extends AbstractVerticle {
    HttpServer server;

    @Inject
    HelloService helloService;

    @Override
    public void start() {
        server = vertx.createHttpServer();

        server.requestHandler(req ->{
            HttpServerResponse resp = req.response();
            resp.putHeader("content-type", "text/plain");
            resp.end(helloService.hello());
        }).listen(8181);
    }

    @Override
    public void stop() throws Exception {
        if (server != null) {
            server.close();
            server = null;
        }
    }
}
