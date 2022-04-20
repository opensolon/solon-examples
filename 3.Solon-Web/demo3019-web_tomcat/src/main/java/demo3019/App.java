package demo3019;

import org.noear.solon.Solon;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author noear 2022/4/20 created
 */
public class App implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Solon.start(App.class, new String[]{}, app -> {
            //取消文件运行模式
            Solon.cfg().isFilesMode(false);
        });
    }
}
