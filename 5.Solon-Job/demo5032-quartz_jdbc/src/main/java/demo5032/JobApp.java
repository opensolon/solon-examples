package demo5032;

import org.noear.solon.Solon;
import org.noear.solon.core.util.LogUtil;
import org.noear.solon.extend.quartz.EnableQuartz;
import org.noear.solon.logging.utils.LogUtilToSlf4j;

@EnableQuartz
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args, app->{
            LogUtil.globalSet(new LogUtilToSlf4j());
        });
    }
}
