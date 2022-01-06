package demo1001.demo1.dso;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.aspect.annotation.Service;

import java.util.Properties;

/**
 * 如何通过注入获得配置？
 *
 * @author noear 2021/12/28 created
 */
@Service
public class DemoService {
    //注入值（带默认值：demoApi），并开启自动更新（注意：如果不是单例，请不要开启自动刷新）
    @Inject(value="${track.name:demoApi}", autoRefreshed=true)
    String trackName;

    //注入值（没有时，不覆盖字段初始值）
    @Inject("${track.url}")
    String trackUrl = "http://x.x.x/track";

    //注入配置集合
    @Inject("${track.db1}")
    Properties trackDbCfg;

    //注入Bean（根据对应的配置集合自动生成并注入）
    @Inject("${track.db1}")
    HikariDataSource trackDs;

    public DemoService(){
        //注入的配置，不能在构造函数里使用。在生命周期时，构建先于注入
    }

    @Init
    public void init(){
        //注入的配置，需要进一步做初始化，请在处理
    }
}
