package demo4010_rx.controller;

import demo4010_rx.model.Appx;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.data.rx.sql.RxSqlUtils;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author noear 2024/12/25 created
 */
@Controller
public class DemoController {
    @Inject("h2")
    RxSqlUtils sqlUtils;

    @Mapping("case1")
    public Mono<Number> case1() {
        return sqlUtils.sql("select 1")
                .queryValue(Number.class);
    }

    @Mapping("case2")
    public Mono<List<Integer>> case2() {
        return sqlUtils.sql("select app_id from appx limit 2")
                .queryValueList(Integer.class)
                .collectList();
    }

    @Mapping("case3")
    public Mono<Appx> case3() {
        return sqlUtils.sql("select * from appx limit 1")
                .queryRow(Appx.class);
    }

    @Mapping("case4")
    public Mono<List<Appx>> case4() {
        return sqlUtils.sql("select * from appx limit 2")
                .queryRowList(Appx.class)
                .collectList();
    }
}
