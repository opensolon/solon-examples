package demo2010;

import org.noear.solon.Solon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author noear 2023/1/7 created
 */
public class App {
    public static void main(String[] args) throws Exception{
        Solon.start(App.class, args);

        Logger log = LoggerFactory.getLogger(App.class);

        for (int i = 0; i < 100; i++) {
            log.info(i + ":" + new Date());
            Thread.sleep(10);
        }
    }
}
