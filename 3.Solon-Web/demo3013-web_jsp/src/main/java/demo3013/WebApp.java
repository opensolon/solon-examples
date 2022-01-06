package demo3013;

import org.noear.solon.Solon;

/**
 *
 * //资源路径说明（不用配置）
 * resources/app.properties（或 app.yml） 为应用配置文件
 * resources/static/ 为静态文件根目标
 * resources/WEB-INF/view/ 为视图文件根目标（支持多视图共存）
 *
 * */
public class WebApp {
    public static void main(String[] args) {
        Solon.start(WebApp.class, args);
    }
}
