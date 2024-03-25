package demo1092;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;

/**
 * @author noear 2024/3/25 created
 */
@Component
public class VertxHttpServer implements LifecycleBean {
    @Inject
    Vertx vertx;
    HttpServer server;

    @Override
    public void start() throws Throwable {
        server = vertx.createHttpServer();

        server.requestHandler(req ->{
            HttpServerResponse resp = req.response();
            resp.putHeader("content-type", "text/plain");
            resp.end("Hello wrold!");
        }).listen(8181);
    }

    @Override
    public void stop()  throws Throwable {
        if (server != null) {
            server.close();
            server = null;
        }
    }
}
