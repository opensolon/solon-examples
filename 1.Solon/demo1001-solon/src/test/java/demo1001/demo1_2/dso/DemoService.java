package demo1001.demo1_2.dso;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Solon;

import java.util.Properties;

/**
 * 如何手动获得配置？
 *
 * @author noear 2021/12/28 created
 */
public class DemoService {
    //获取值（带默认值：demoApi）
    String trackName = Solon.cfg().get("track.name", "demoApi");
    //获取值
    String trackUrl = Solon.cfg().get("track.url");
    //获取配置集合
    Properties trackDbCfg = Solon.cfg().getProp("track.db1");
    //获取bean（根据配置集合自动生成）
    HikariDataSource trackDs = Solon.cfg().getBean("track.db1", HikariDataSource.class);
}
