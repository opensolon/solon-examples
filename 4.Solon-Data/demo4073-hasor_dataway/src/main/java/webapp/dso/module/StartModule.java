package webapp.dso.module;

import com.zaxxer.hikari.HikariDataSource;
import net.hasor.core.ApiBinder;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.web.WebApiBinder;
import net.hasor.web.WebModule;
import org.noear.solon.Solon;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.ExtendLoader;
import org.noear.solon.core.Props;
import webapp.dso.DsHelper;

import javax.sql.DataSource;
import java.util.Properties;

@Component
public class StartModule implements WebModule {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(buildDs());
    }

    @Override
    public void loadModule(WebApiBinder webApiBinder) throws Throwable {
        webApiBinder.installModule(buildDs());
    }

    private JdbcModule buildDs() {
        //for mysql
        //DataSource ds = Solon.cfg().getProp("db1").getBean(HikariDataSource.class)

        //for h2
        DataSource ds = buildH2Ds();

        return new JdbcModule(Level.Full, ds);
    }

    private DataSource buildH2Ds() {
        //1.替换H2的持久化路径（路径要变，所以不做自动注入处理）
        Props props = Solon.cfg().getProp("db1");
        props.setProperty("jdbcUrl", props.getProperty("jdbcUrl").replace("~/", ExtendLoader.path()));

        //2.生成DataSource
        DataSource ds = props.getBean(HikariDataSource.class);

        try {
            //3.需要初始化schame（第一次会成功；之后会失败；不用管...）
            DsHelper.initData(ds);
        } catch (Exception ex) {

        }

        return ds;
    }
}
