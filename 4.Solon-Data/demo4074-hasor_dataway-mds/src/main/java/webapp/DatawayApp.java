package webapp;

import net.hasor.solon.boot.EnableHasor;
import net.hasor.solon.boot.EnableHasorWeb;
import org.noear.solon.Solon;
import webapp.dso.module.StartModule;

@EnableHasor(startWith = StartModule.class)
@EnableHasorWeb
public class DatawayApp {
    public static void main(String[] args) throws Throwable {
        Solon.start(DatawayApp.class, args);
    }
}
